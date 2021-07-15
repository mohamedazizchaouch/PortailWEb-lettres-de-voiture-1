package com.example.demo.restapi;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.FacturePdfexport;
import com.example.demo.model.Imprimeur;
import com.example.demo.model.comm_encours_expoterpdf;
import com.example.demo.service.Imprimeur_service;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping(value = "/api/imprimeur")
public class ImprimeurRestApi {
	
	@Autowired
	private Imprimeur_service  imps ;
	
	
	
	@PostMapping
	public int creatimp(@RequestBody Imprimeur i) {
	return 	imps.addimprimeur(i);

	}
	@GetMapping
	public List<Imprimeur>getall(){
		return imps.getall();
	}
	
	@GetMapping(value = "/{id}")
	public Imprimeur getimp_byid(@PathVariable int id) {
		return imps.getimp_byid(id);
	}
	
	@GetMapping(value = "/dossier_encours/{id}")
	public List<Commande> get_dossier_encours(@PathVariable int id){
		return imps.commandeencours_imprimeur(id);
	}
	
	@GetMapping(value = "/dossier_a_facturer/{id}")
	public List<Commande> get_dossier_a_facturer(@PathVariable int id){
		return imps.commande_pret_a_facturer(id);
	}
	
	@GetMapping(value  ="dossier_a_livrer/{id}")
	public List<Commande> get_dossier_pret_alivrer(@PathVariable int id){
		return imps.commande_pret_a_livrer(id);
	}
	
	//envoyer facture par mail 
	@GetMapping(value = "/envoie_mail_pdf/{id}")
	public void valider_facture(@PathVariable int id) {
		imps.mail(id);
	}
	
	//pdf facture
	
	@GetMapping(value = "/pdf_facture/{idc}",produces = MediaType.APPLICATION_PDF_VALUE)
	
	public void export_pdf_facture(HttpServletResponse response,@PathVariable int idc) throws Exception {
		
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDatetime = dateformatter.format(new Date());
		
		response.setContentType("applicatipn pdf");
		String headerkey="content-disposition";
		String headerValue="attachment; filename=Facture-"+currentDatetime+".pdf";
		response.setHeader(headerkey, headerValue);
		
		imps.writePdf1(response, idc);
		
	}
	
	@GetMapping(value = "/pdf_liv/{idc}",produces = MediaType.APPLICATION_PDF_VALUE)
	
	public void export_pdf_liv(HttpServletResponse response,@PathVariable int idc) throws Exception {
		
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDatetime = dateformatter.format(new Date());
		
		response.setContentType("applicatipn pdf");
		String headerkey="content-disposition";
		String headerValue="attachment; filename=Facture-"+currentDatetime+".pdf";
		response.setHeader(headerkey, headerValue);
		
		imps.writePdf_bon_liv(response, idc);
		
	}
	
	
	//export pdf les commande encours 
	@GetMapping(value = "/expoter_txt_comm_encours/{idimp}",produces = MediaType.APPLICATION_PDF_VALUE)
	
	public void export_comm_encours(HttpServletResponse response,@PathVariable int idimp) throws Exception {
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDatetime = dateformatter.format(new Date());
		
		response.setContentType("applicatipn pdf");
		String headerkey="content-disposition";
		String headerValue="attachment; filename=commande_encours-"+currentDatetime+".pdf";
		response.setHeader(headerkey, headerValue);
		
		imps.fichier_imp_comm_encours(response, idimp);
		
	}
	
	@GetMapping(value = "/aaaa/{id}")
	
	public void doGet(HttpServletRequest request, HttpServletResponse response,@PathVariable int id) throws ServletException, java.io.IOException {
	  
	 imps.doGet(request, response, id);
	}
	
	
@GetMapping(value = "/clts/{id}")
public List<Client>getallls(@PathVariable int id){
	return imps.get_clt_imp(id);
}
	
}
