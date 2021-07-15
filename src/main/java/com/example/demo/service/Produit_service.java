package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.ImprimeurDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.model.Commande;
import com.example.demo.model.Imprimeur;
import com.example.demo.model.Produit;

@Service
public class Produit_service {

	@Autowired
	private ProduitDao produit_dao ;
	
	@Autowired
	private CommandeDao com_dao ;
	@Autowired
	private ImprimeurDao impdao;
	public int addproduit(Produit p) {
		produit_dao.save(p);
		return 1 ;
	}
	
	public Produit getproduitbyid(int id) {
		return produit_dao.findById(id).get();
	}
	public List<Produit> getallproduit(){
		return produit_dao.findAll() ;
	}
	
	public String affectercmd_imp (int idimp,int idc) {
		Imprimeur i= impdao.findById(idimp).get();
		Commande c = com_dao.findById(idc).get();
		i.getCommande().add(c);
		c.setImprimeur(i);
		impdao.save(i);
		com_dao.save(c);
		return "donne" ;
		
	}
	
	public String affecterproduit_to_commande(int idp,int idc) {
		Produit p = produit_dao.findById(idp).get();
		Commande c = com_dao.findById(idc).get();
		p.setCommande(c);
		c.setProduit(p);
		com_dao.save(c);
		produit_dao.save(p);
	System.out.print(p.getFrais_port());
		return "affecter" ;
	}
}
