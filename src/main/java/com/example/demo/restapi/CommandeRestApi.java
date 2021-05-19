package com.example.demo.restapi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommandeDao;
import com.example.demo.model.Cl;
import com.example.demo.model.Commande;
import com.example.demo.model.Etat_commande;
import com.example.demo.model.Produit;
import com.example.demo.model.Scarnet;
import com.example.demo.model.Sclient;
import com.example.demo.service.Commande_service;
import com.example.demo.service.Produit_service;
import com.example.demo.service.Statistique_service;

@RestController
@RequestMapping(value = "/api/commande")
public class CommandeRestApi {
	
	@Autowired
	private Commande_service comm_service ;
	
	@Autowired
	private Produit_service ps;
	@Autowired
	private Statistique_service ss;
	
	//affecte produit to commande
	@GetMapping(value = "/aff_p_to_c/{idp}/{idc}")
	public String get(@PathVariable int idp , @PathVariable int idc) {
		
		return ps.affecterproduit_to_commande(idp, idc);
	}
//affecte client to commande 
	@GetMapping(value = "/aff_c_to_com/{idcom}/{idcl}")
	public String aff_c_to_com(@PathVariable int idcom ,@PathVariable int idcl) {
		return comm_service.affecte_comm_to_client(idcom, idcl);
	}
	
	@PostMapping(value = "/{ida}")
	public int createcommande(@RequestBody Commande c,@PathVariable int ida) {
		c.setDate_creation_dossier(new Date());
		c.setEtat_commande(Etat_commande.Encours_BAT);
		comm_service.addcommande(c,ida);
		return 1;
	}
	
	@GetMapping (produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Commande> getalls(){
		return comm_service.getallcommande();
	}
	
	
	@DeleteMapping(value = "{id}")
	public String deletecommande(@PathVariable int id) {
		return comm_service.deleteCommande(id) ;}

	
	//historique commande
	@GetMapping(value = "/historique" )
	public List<Commande>gettetat(){
		return comm_service.getcomm_historique();
	}
	//commande encours 
	@GetMapping(value = "/encours")
	public List<Commande>getcomm_encours(){
		return comm_service.getcomm_encours();
	}
	
	//bat valider
	@GetMapping(value = "/batvalider")
	public List<Commande> getcomm_valider(){
		
		return comm_service.getcomm_batvalider();
	}
	
	//bat refussr
	@GetMapping(value = "/batrefuser")
	public List<Commande> getcomm_refuser(){
		return comm_service.getcomm_batrefuser();
	}
	
	//impression
	@GetMapping(value = "/batimprimer")
	public List<Commande> getcomm_impression(){
		return comm_service.getcomm_impression();
	}
	
	
}
