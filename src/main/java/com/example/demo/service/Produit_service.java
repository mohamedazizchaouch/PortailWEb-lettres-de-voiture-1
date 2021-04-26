package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.model.Commande;
import com.example.demo.model.Produit;

@Service
public class Produit_service {

	@Autowired
	private ProduitDao produit_dao ;
	
	@Autowired
	private CommandeDao com_dao ;
	
	public int addproduit(Produit p) {
		produit_dao.save(p);
		return 1 ;
	}
	public List<Produit> getallproduit(){
		return produit_dao.findAll() ;
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
