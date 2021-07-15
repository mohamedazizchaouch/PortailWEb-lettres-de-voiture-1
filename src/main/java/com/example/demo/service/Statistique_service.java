package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.ProduitDao;
import com.example.demo.model.Cl;
import com.example.demo.model.Commande;
import com.example.demo.model.Produit;
import com.example.demo.model.Scarnet;
import com.example.demo.model.Sclient;
import com.example.demo.model.Suser_ville;

@Service
public class Statistique_service {
	
	@Autowired
	private ProduitDao prdao;
	 @Autowired
	 private CommandeDao comdao ;
	 
	public List<Cl>stat_refproduit(){
		return comdao.stat_refproduit();
	}
	
	public List<Sclient> stat_nbrclient(){
		return comdao.stat_nbrclient();	}
	
	public List<Scarnet>stat_nbrcarnet(){
		return comdao.stat_nbrcarnet();
	}
	
	public List<Suser_ville>stat_nbrclt_par_gouvernerat(){
		return comdao.stat_clt_pargov();
	}
	
	public List<Suser_ville>stat_nbrclt_par_cp(){
		return comdao.stat_clt_par_cp()
;	}
}
