package com.example.demo.restapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Commentaire_BAT;
import com.example.demo.service.commentaireBat_service;
@RestController
@RequestMapping(value = "/api/comm_bat")
public class commentaireBatRestApi {
	
	@Autowired
	private commentaireBat_service cs ;
	
	@PostMapping(value = "/ajout_comm_client/{idcl}/{idf}")
	public int addcommentaire_client(@PathVariable int idcl,@PathVariable int idf ,@RequestBody Commentaire_BAT c) {
		
		
		c.setDate_heure_commentaire(new Date());
		return cs.ajouter_commentaire_client(idcl, idf, c);
	}
	
	@PostMapping(value = "/ajout_comm_imprimeur/{idi}/{idf}")
	public int addcommentaire_imprimeur(@PathVariable int idi,@PathVariable int idf ,@RequestBody Commentaire_BAT c) {
		
		
		c.setDate_heure_commentaire(new Date());
		return cs.ajouter_commentaire_imprimeur(idi, idf, c);
	}
	@GetMapping(value = "/{id}")
	public List<Commentaire_BAT>getcomms(@PathVariable int id){
		return cs.getcomms_by_fich_bat(id);
	}
	
	
	
	
	
}
