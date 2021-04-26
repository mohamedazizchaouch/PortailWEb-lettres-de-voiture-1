package com.example.demo.restapi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Commentaire_commande;
import com.example.demo.service.CommentaireCom_service;

@RestController
@RequestMapping(value = "/api/commentaire_com")
public class CommentaireCommRestApi {
	
	@Autowired
	private CommentaireCom_service cs ;
	
	@PostMapping(value = "/ajouter_com_imp/{idi}/{idc}")
	public int ajout_comm_imp(@RequestBody Commentaire_commande c ,@PathVariable int idi ,@PathVariable int idc) {
		c.setDate_heure_commentaire(new Date());
		return cs.ajouter_commenttaire_imprimeur(c, idi, idc);
	}
	
	
	@PostMapping(value = "/ajouter_com_admin/{ida}/{idc}")
public int ajouter_comm_admin(@RequestBody Commentaire_commande c ,@PathVariable int ida ,@PathVariable int idc) {
		c.setDate_heure_commentaire(new Date());
		return cs.ajouter_commentaire_admin(c, ida, idc);
	}
	
	@GetMapping(value ="/{idc}")
	public List<Commentaire_commande> get(@PathVariable int idc){
		return cs.get_comm_by_commande(idc);
	}
	
}
