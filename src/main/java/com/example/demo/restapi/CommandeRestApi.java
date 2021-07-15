package com.example.demo.restapi;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CommandeDao;
import com.example.demo.model.Cl;
import com.example.demo.model.Commande;
import com.example.demo.model.Data;
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
	
	
	@GetMapping(value = "zzzz")
	public List<Data>aaaa(){
		return comm_service.getalltasktest();
	}
	
	@PutMapping(value = "/modifdate/{id}")
	public String modif_date(@PathVariable int id ,@RequestBody Commande nc) {
		return comm_service.modif_date_creation_dossier(id, nc);
	}
	@PutMapping(value = "/modifdate_etat/{id}")
	public String modif_date_etat(@PathVariable int id ,@RequestBody Commande nc) {
		return comm_service.modif_date_creation_dossier_etat(id, nc);
	}
	
	
	//modiftext_repliquer
	@PutMapping(value = "/modift/{id}")
	public String modif_t(@PathVariable int id ,@RequestBody Commande nc) {
		return comm_service.Modif_text_arepliquer(nc, id);
	}
	@PutMapping(value = "/modifqunt/{id}")
	public String modif_qunt(@PathVariable int id ,@RequestBody Commande nc) {
		return comm_service.modif_qunt(nc, id);
	}
	
	//affecte imp to cmd 
	@GetMapping(value = "/aff_i_to_c/{idi}/{idc}")
	public String affecte(@PathVariable int idi ,@PathVariable int idc) {
		return ps
				.affectercmd_imp(idi, idc);
	}
	
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
	public Commande createcommande(@RequestBody Commande c,@PathVariable int ida) {
	
		c.setDate_commande(new Date());
		c.setEtat_commande(Etat_commande.Encours_BAT);
		
		return comm_service.addcommande(c,ida);
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
	
	@GetMapping(value = "/{id}")
	public Commande getcmd_by_id(@PathVariable int id) {
		return comm_service.getcmd_byid(id);
	}
	
}
