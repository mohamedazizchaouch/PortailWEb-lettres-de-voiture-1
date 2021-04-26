package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Admin_venteDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.model.Admin_vente;
import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.Etat_commande;

@Service
public class Commande_service {

	
	@Autowired
	private CommandeDao commdao ;
	@Autowired
	private Admin_venteDao adddao;
	
	@Autowired
	private ClientDao cldao ;
	
	public int addcommande(Commande c,int ida) {
		Admin_vente a=  adddao.findById(ida).get();
		a.getCommandes().add(c);
		c.setAdmin_vente(a);
		adddao.save(a);
		commdao.save(c);
		return 1 ;
	}
	
	
//affecte commande client
	
public String affecte_comm_to_client(int idcom, int idcl) {
	
	Client c= cldao.findById(idcl).get();
	Commande com = commdao.findById(idcom).get();
	c.getCommande().add(com);
	com.setClient(c);
	cldao.save(c);
	commdao.save(com);
	
	return "sdndsnsdn";
}


	public String deleteCommande(int id) {
		if (commdao.findById(id).isPresent()) {
			commdao.deleteById(id);
			return "commande  supprimé";
		} else
			return "commande non supprimé";
	}
	
	public List<Commande> getallcommande(){
		return commdao.findAll();
	}
	
	
	// historique commande 
	public List<Commande> getcomm_historique(){
		List<Commande> comms = new ArrayList<Commande>() ;
		List<Commande> commds =commdao.findAll();
		for(int i=0;i<commds.size();i++) {
			if(commds.get(i).getEtat_commande()==Etat_commande.Livraison) {
			
				comms.add(commds.get(i));
			}
		}
		return comms ;
	}
	
	public List<Commande> getcomm_encours (){
		List<Commande> comms = new ArrayList<Commande>() ;
		List<Commande> commds =commdao.findAll();
		for(int i=0;i<commds.size();i++) {
			if(commds.get(i).getEtat_commande()==Etat_commande.Encours_BAT) {
				
				comms.add(commds.get(i));
			}
		}
		return comms ;
		
	}
	
	public List<Commande> getcomm_impression(){
		
		List<Commande> comms = new ArrayList<Commande>() ;
		List<Commande> commds =commdao.findAll();
		for(int i=0;i<commds.size();i++) {
			if(commds.get(i).getEtat_commande()==Etat_commande.Impression) {
				
				comms.add(commds.get(i));
			}
		}
		return comms ;
		
	}
	
	public List<Commande> getcomm_batvalider(){
		
		List<Commande> comms = new ArrayList<Commande>() ;
		List<Commande> commds =commdao.findAll();
		for(int i=0;i<commds.size();i++) {
			if(commds.get(i).getEtat_commande()==Etat_commande.BAT_accepter) {
				
				comms.add(commds.get(i));
			}
		}
		return comms ;
		
	}
	
	public List <Commande> getcomm_batrefuser (){
		
		List<Commande> comms = new ArrayList<Commande>() ;
		List<Commande> commds =commdao.findAll();
		for(int i=0;i<commds.size();i++) {
			if((commds.get(i).getEtat_commande()==Etat_commande.Bat_refuser )||(commds.get(i).getEtat_commande()==Etat_commande.Modification_BAT) ) {
			
				comms.add(commds.get(i));
			}
		}
		return comms ;
		
	}
}
