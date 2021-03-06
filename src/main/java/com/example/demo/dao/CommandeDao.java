package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Cl;
import com.example.demo.model.Commande;
import com.example.demo.model.Scarnet;
import com.example.demo.model.Sclient;
import com.example.demo.model.Suser_ville;

public interface CommandeDao extends JpaRepository<Commande, Integer>{
	
	@Query("select new com.example.demo.model.Cl(p.nom_produit ,count(*))  from Commande c ,Produit p where p.id_produit=c.produit GROUP BY c.produit")
	public List<Cl> stat_refproduit();
	
	@Query("select new com.example.demo.model.Sclient(cl.code_client , count(*))from Client cl ,Commande c where cl.id =c.client GROUP BY c.client ")
	public List<Sclient> stat_nbrclient();
	
	@Query("select new com.example.demo.model.Scarnet(Sum(c.quntite),p.nom_produit) from Commande c ,Produit p where p.id_produit=c.produit GROUP BY c.produit ")
	public List<Scarnet>stat_nbrcarnet();
	
	@Query("select  new com.example.demo.model.Suser_ville(count(*),cl.gouvernorat) from Commande c , Client cl where cl.id =c.client GROUP BY gouvernorat")
	public List<Suser_ville>stat_clt_pargov();
	
	
	@Query("select  new com.example.demo.model.Suser_ville(count(*),cl.code_postal_adresse_facturation) from Commande c , Client cl where cl.id =c.client GROUP BY code_postal_adresse_facturation")
	public List<Suser_ville>stat_clt_par_cp();
	

}
