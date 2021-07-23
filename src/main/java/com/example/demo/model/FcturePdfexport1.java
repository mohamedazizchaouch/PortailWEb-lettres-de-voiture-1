package com.example.demo.model;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class FcturePdfexport1 {
	private List<Commande> com ;

	public FcturePdfexport1(List<Commande> com) {
		super();
		this.com = com;
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
for(Commande c : com) {
	table.addCell(""+c.getNum_commande());
	table.addCell(""+c.getProduit().getNom_produit());
	table.addCell(""+c.getQuntite());
	table.addCell(""+c.getPrix_vente_HT());
		}
		
		table.addCell("carnet type T");
		table.addCell("150");
		table.addCell("2558.30");
		
		
	}
	public void export(HttpServletResponse response) throws DocumentException, IOException, BadElementException {
	double x =	(com.get(0).getQuntite()*com.get(0).getPrix_vente_HT())+com.get(0).getFrais_transport_achat_HT();
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
		
		document.add(new Paragraph(" Facture du CLIENT : "+com.get(0).getClient().getCode_client(),font));
		document.add(new Paragraph("-------------------------------"));
		document.add(new Paragraph("N de la facture : "+0001));
		document.add(new Paragraph("Date de la facture : "+currentDatetime ));
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
