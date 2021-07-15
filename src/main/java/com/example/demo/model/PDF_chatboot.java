package com.example.demo.model;

import java.io.IOException;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PDF_chatboot {

	private String nom;
	private String Prenom ;
	private String raison_social;
	private String mail ;
	private String addresse;
	private int num_tell;
	private int num_fax;
	public PDF_chatboot(String nom, String prenom, String raison_social, String mail, String addresse, int num_tell,
			int num_fax) {
		super();
		this.nom = nom;
		Prenom = prenom;
		this.raison_social = raison_social;
		this.mail = mail;
		this.addresse = addresse;
		this.num_tell = num_tell;
		this.num_fax = num_fax;
	}
	
	public void export(OutputStream  response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response);
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph(""));
		document.add(new Paragraph(""));
		document.add(new Paragraph("                                                       Demande d'inscription",font));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
	
	
		
		document.add(new Paragraph("Bonjour, je me présente Mr "+nom+" "+Prenom+" directeur général de la société "+raison_social+" ."));
		document.add(new Paragraph("Je souhaite m'inscrire à votre portail web de vente de lettre de voiture."));
		document.add(new Paragraph("Veuillez trouver ci-joint mon numéro de téléphone / Fax :"+num_tell+" / "+num_fax+" ainsi que l'adresse de facturation : "+addresse+" ."));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("\n"));
		document.add(new Paragraph("                                                                                                       Merci à vous."));
		document.add(new Paragraph("                                                                                                       "+mail));
		document.close();
	}
	
}
