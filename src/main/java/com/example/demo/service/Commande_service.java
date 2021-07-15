package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Admin_venteDao;
import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.model.Admin_vente;
import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.Data;
import com.example.demo.model.Etat_commande;

@Service
public class Commande_service {

	
	@Autowired
	private CommandeDao commdao ;
	@Autowired
	private Admin_venteDao adddao;
	
	@Autowired
	private ClientDao cldao ;
	
	public Commande getcmd_byid(int id) {
		return commdao.findById(id).get();
	}
	
	public String modif_qunt(Commande nc , int id) {
		Commande c= commdao.findById(id).get();
		c.setQuntite(nc.getQuntite());
		commdao.save(c);
		return "modiiff";
	}
	
	public String modif_date_creation_dossier(int id, Commande nc) {
		Commande c= commdao.findById(id).get();
		c.setDate_creation_dossier(nc.getDate_creation_dossier());
		commdao.save(c);
		return "modiiff";
	}
	public String modif_date_creation_dossier_etat(int id, Commande nc) {
		Commande c= commdao.findById(id).get();
		c.setDate_creation_dossier(nc.getDate_creation_dossier());
		c.setEtat_commande(Etat_commande.Impression);
		commdao.save(c);
		return "modiiff";
	}
	
	
	
	public String  Modif_text_arepliquer(Commande nc,int id) {
		Commande c= commdao.findById(id).get();
		c.setText_a_repliquer(nc.getText_a_repliquer());
		commdao.save(c);
		
		return "modff";
	}
	
	public Commande addcommande(Commande c,int ida) {
		Admin_vente a=  adddao.findById(ida).get();
		a.getCommandes().add(c);
		c.setAdmin_vente(a);
		commdao.save(c);
		adddao.save(a);
		
		return c ;
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
	@SuppressWarnings("deprecation")
	public List<Data> getalltasktest(){
		 SimpleDateFormat dateFormat = new
	                SimpleDateFormat ("yyyy-MM-dd");
		 Date dn = new Date();
		List<Data> dts = new ArrayList<Data>();
		int i =0;
		for(Commande c : commdao.findAll()) {
		
			if(c.getEtat_commande()==Etat_commande.Impression) {
				if(c.getDate_creation_dossier().compareTo(new Date())==-1) {
					c.setEtat_commande(Etat_commande.Livraison);
					commdao.save(c);
				}
				
			}
			
		}
		
		for(Commande c : commdao.findAll()) {
			
			if(c.getEtat_commande()==Etat_commande.Impression) {
				
				i=i+1;
				Data a = new Data(i, "Cmd N :"+c.getNum_commande()+"| Client :"+c.getClient().getCode_client(), c.getDate_creation_dossier(), c.getDate_creation_dossier(), true);
				dts.add(a);
			}
			
		}
		
		return dts;
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
			if((commds.get(i).getEtat_commande()==Etat_commande.Encours_BAT)||(commds.get(i).getEtat_commande()==Etat_commande.Attente_validation_BAT)||
					(commds.get(i).getEtat_commande()==Etat_commande.Modification_BAT)||(commds.get(i).getEtat_commande()==Etat_commande.Bat_refuser)) {
				
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
