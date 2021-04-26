package com.example.demo.model;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class comm_encours_expoterpdf {
	private List<Commande> com ;

	public comm_encours_expoterpdf(List<Commande> com) {
		super();
		this.com = com;
	}
	
	private void WriteTableHeader(PdfPTable table) {
		
	}
	
	private void WriteTableData(PdfPTable table) {
		
	}
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		document.add(new Paragraph("les commandes encours :"));
		for(Commande c : com) {
			
				document.add(new Paragraph(""+c.getDate_commande()+"  ;  "+c.getProduit().getId_produit()+"  ;  "+c.getQuntite()+"  ;  "+c.getEtat_commande()+"  ;  "+c.getNum_commande()));
					
			
			
		}
		document.close();
		
		
	}

}
