package com.example.demo.model;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class bon_liv {
	private Commande c ;

	public bon_liv(Commande c) {
		super();
		this.c = c;
	}
	private void WriteTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("numero commande "));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("nom produit "));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("quntite "));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("prix "));
		table.addCell(cell);
		
	}
	private void WriteTableData(PdfPTable table) {
	
			table.addCell(""+c.getNum_commande());
			table.addCell(""+c.getProduit().getNom_produit());
			table.addCell(""+c.getQuntite());
			table.addCell(""+c.getPrix_vente_HT());
				
				
				
				
			}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		double x =	(c.getQuntite()*c.getPrix_vente_HT())+c.getFrais_transport_achat_HT();
		double xttc = x+(x*0.18);
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document,  response.getOutputStream());
			DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
			String currentDatetime = dateformatter.format(new Date());
			document.open();
			Font font = FontFactory.getFont(FontFactory.HELVETICA);
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			document.add(new Paragraph(" Bon de livraison du CLIENT : "+c.getClient().getCode_client(),font));
			document.add(new Paragraph(" Numero Client : "+c.getClient().getNum_Telephone(),font));
			document.add(new Paragraph(" Adresse de livraison : "+c.getClient().getGovvernorat_liv()+"|"+c.getClient().getVille_adresse_facturation_liv()
					+"|"+c.getClient().getRue_adresse_facturation()+"|"+c.getClient().getCode_postal_adresse_liv(),font));
			document.add(new Paragraph("-------------------------------"));
			document.add(new Paragraph("Bon de livraison N°: "+0001));
			document.add(new Paragraph("Date  : "+currentDatetime ));
			document.add(new Paragraph("A payer TTC  : "+xttc+" DT"));
			PdfPTable table = new PdfPTable(4);
			table.setWidthPercentage(100);
			table.setSpacingBefore(20);
			table.setSpacingAfter(20);
			WriteTableHeader(table);
			WriteTableData(table);
			document.add(table);
			document.add(new Paragraph("                                                                                                      Montant Total HT : "+x+" DT"));
			document.add(new Paragraph("                                                                                                      Montant TAX : "+(x*0.18)+" DT"));
			document.add(new Paragraph("                                                                                                      Montant Total TTC : "+xttc+" DT"));
			
			document.close();

		}


}
