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
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.Facturedao;
import com.example.demo.dao.ImprimeurDao;
import com.example.demo.model.Commande;
import com.example.demo.model.Etat_commande;
import com.example.demo.model.Facture;
import com.example.demo.model.FacturePdfexport;
import com.example.demo.model.Fichier_BAT;
import com.example.demo.model.Imprimeur;
import com.example.demo.model.comm_encours_expoterpdf;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



@Service
public class Imprimeur_service {
	
	@Autowired
	private ImprimeurDao impdao ;
	@Autowired
	private CommandeDao comdao;
	
	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	private Facturedao fdao ;
	
	
	public int addimprimeur(Imprimeur i) {
		impdao.save(i);
		return 1;
	}
	
	
	
	//dossier encours (espace imprimeur)
	public 	List<Commande>commandeencours_imprimeur(int idimp){
		Imprimeur i = impdao.findById(idimp).get();
		List<Commande>cc = new ArrayList<>();
	for(Fichier_BAT f : i.getFichiers_BAT()) {
		if((f.getCommande().getEtat_commande()!=Etat_commande.Livraison )|| (f.getCommande().getEtat_commande()!=Etat_commande.Expedier ))
		cc.add(f.getCommande());
	}
		
		return cc;
	}
	//fichier txt commande encours 
	public void  fichier_imp_comm_encours(HttpServletResponse response,int idimp) throws Exception{
	
		
		 List<Commande> com =commandeencours_imprimeur(idimp);
		  
			comm_encours_expoterpdf comms = new comm_encours_expoterpdf(com);
			comms.export(response);
		
	}
	
	
	
	//liste des facture (espace imprimeur)
	public 	List<Commande>commande_pret_a_facturer(int idimp){
		Imprimeur i = impdao.findById(idimp).get();
		List<Commande>cc = new ArrayList<>();
	for(Fichier_BAT f : i.getFichiers_BAT()) {
		if(f.getCommande().getEtat_commande()==Etat_commande.Expedier)
		cc.add(f.getCommande());
	}
		
		return cc;
	}
	
	


	public void writePdf(OutputStream outputStream,int idc) throws Exception {
	
	    Document document = new Document();
	    PdfWriter.getInstance(document, outputStream);
	   
	    
	    List<Commande> com = new ArrayList<Commande>();
	    com.add(comdao.findById(idc).get());
	    FacturePdfexport facture = new FacturePdfexport(com);
		facture.export(outputStream);
	}
	//valider facutre
	public void mail(int idco) {
		
		Commande c= comdao.findById(idco).get();
		c.setEtat_commande(Etat_commande.Livraison);
	comdao.save(c);
	Facture f =new Facture();
	f.setDate_commande(c.getDate_commande());
	f.setDate_creation_dossier(c.getDate_creation_dossier());
	f.setFrais_transport_achat_HT(c.getFrais_transport_achat_HT());
	f.setPrix_achat_HT(c.getPrix_achat_HT());
	f.setPrix_vente_HT(c.getPrix_vente_HT());
	fdao.save(f);
	
	
		String smtpHost = "smtp.gmail.com"; //replace this with a valid host
	    int smtpPort = 587; //replace this with a valid port

	    String sender = "pfe.itsterone@gmail.com"; //replace this with a valid sender email address
	    String recipient = "med.dhia.hajjem93@gmail.com"; //replace this with a valid recipient email address
	    String content = "vous trouvez votre facture ci-joint"; //this will be the text of the email
	    String subject = "Facture lettre de voiture";
	    
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
     writePdf(outputStream,idco);
     byte[] bytes = outputStream.toByteArray();
   //construct the pdf body part
     DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
     MimeBodyPart pdfBodyPart = new MimeBodyPart();
     pdfBodyPart.setDataHandler(new DataHandler(dataSource));
     pdfBodyPart.setFileName("Facture.pdf");
	
     
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
