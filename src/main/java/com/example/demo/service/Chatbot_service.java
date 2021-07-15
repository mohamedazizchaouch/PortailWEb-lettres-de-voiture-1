package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Commande;
import com.example.demo.model.Etat_commande;
import com.example.demo.model.Facture;
import com.example.demo.model.FacturePdfexport;
import com.example.demo.model.PDF_chatboot;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class Chatbot_service {
	
	@Autowired
	public JavaMailSender emailSender;
	
	public void writePdf(OutputStream outputStream, String nom, String Prenom , String raison_social, String mail , String addresse, int num_tell,int num_fax
) throws Exception {
		
	    Document document = new Document();
	    PdfWriter.getInstance(document, outputStream);
	   
	    
	  PDF_chatboot demande= new PDF_chatboot(nom, Prenom, raison_social, mail, addresse, num_tell, num_fax);
	   demande.export(outputStream);
	}
	
	
public void mail( String nom, String Prenom , String raison_social, String mail , String addresse, int num_tell,int num_fax
) {

		String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port

	    String sender = "pfe.itsterone@gmail.com"; //replace this with a valid sender email address
	    String recipient = "mohamedaziz.chaouch@esprit.tn"; //replace this with a valid recipient email address
	    String content = "Demande client "+nom+" "+Prenom; //this will be the text of the email
	    String subject = "Nouvelle Demande d'inscription";
	    
	    Properties properties = new Properties();
	    properties.put("mail.smtp.host", smtpHost);
	    properties.put("mail.smtp.port", smtpPort);    
	    properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");
	    Session session = Session.getDefaultInstance(properties, new Authenticator() {
	        protected PasswordAuthentication  getPasswordAuthentication() {
	        return new PasswordAuthentication(
	                    "pfe.itsterone@gmail.com", "az147852369iz");
	                }
	    } );
	    
	    
	    ByteArrayOutputStream outputStream = null;
try {
	  //construct the text body part
	 MimeBodyPart textBodyPart = new MimeBodyPart();
	 textBodyPart.setText(content);
	 
	//now write the PDF content to the output stream
     outputStream = new ByteArrayOutputStream();
     writePdf(outputStream, nom, Prenom, raison_social, mail, addresse, num_tell, num_fax);
     byte[] bytes = outputStream.toByteArray();
   //construct the pdf body part
     DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
     MimeBodyPart pdfBodyPart = new MimeBodyPart();
     pdfBodyPart.setDataHandler(new DataHandler(dataSource));
     pdfBodyPart.setFileName("Demande.pdf");
	
     
     //construct the mime multi part
     MimeMultipart mimeMultipart = new MimeMultipart();
     mimeMultipart.addBodyPart(textBodyPart);
     mimeMultipart.addBodyPart(pdfBodyPart);
     //create the sender/recipient addresses
     InternetAddress iaSender = new InternetAddress(sender);
     InternetAddress iaRecipient = new InternetAddress(recipient);
     
     MimeMessage mimeMessage = new MimeMessage(session);
     mimeMessage.setSender(iaSender);
     mimeMessage.setSubject(subject);
     mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
     mimeMessage.setContent(mimeMultipart);
     
     Transport.send(mimeMessage);

     System.out.println("sent from " + sender + 
             ", to " + recipient + 
             "; server = " + smtpHost + ", port = " + smtpPort);    
}catch(Exception ex) {
    ex.printStackTrace();
} finally {
    //clean off
    if(null != outputStream) {
        try { outputStream.close(); outputStream = null; }
        catch(Exception ex) { }
    }}
	}


}
