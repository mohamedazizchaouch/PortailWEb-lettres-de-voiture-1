package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.Element_graphiqueDao;
import com.example.demo.model.Commande;
import com.example.demo.model.Element_ghraphique;

@Service
public class Elementghraphique_service {
	
	@Autowired
	private Element_graphiqueDao elldao ;
	
	@Autowired
	private CommandeDao comdao ;
	
	
	public int add (Element_ghraphique e, int idc ) {
		Commande c = comdao.findById(idc).get();
		c.getElements_graphique().add(e);
		e.setCommande(c);
		elldao.save(e);
		comdao.save(c);
		
		return 1;
	}
	
	public List<Element_ghraphique> getall(){
		
		return elldao.findAll();
	}
}
