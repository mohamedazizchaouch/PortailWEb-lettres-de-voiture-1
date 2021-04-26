package com.example.demo.restapi;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@GetMapping(value = "/dossier_encours/{id}")
	public List<Commande> get_dossier_encours(@PathVariable int id){
		return imps.commandeencours_imprimeur(id);
	}
	
	@GetMapping(value = "/dossier_a_facturer/{id}")
	public List<Commande> get_dossier_a_facturer(@PathVariable int id){
		return imps.commande_pret_a_facturer(id);
	}
	
	//envoyer facture par mail 
	@GetMapping(value = "/envoie_mail_pdf/{id}")
	public void valider_facture(@PathVariable int id) {
		imps.mail(id);
	}
	//export txt les commande encours 
	@GetMapping(value = "/expoter_txt_comm_encours/{idimp}")
	public void export_comm_encours(HttpServletResponse response,@PathVariable int idimp) throws Exception {
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
		String currentDatetime = dateformatter.format(new Date());
		
		response.setContentType("applicatipn pdf");
		String headerkey="content-disposition";
		String headerValue="attachment; filename=commande_encours-"+currentDatetime+".pdf";
		response.setHeader(headerkey, headerValue);
		
		imps.fichier_imp_comm_encours(response, idimp);
		
	}
	

	
}
