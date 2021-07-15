package com.example.demo.service;

import java.util.ArrayList;
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
	
	public int supp (int ide) {
		
		Element_ghraphique e = elldao.findById(ide).get();
		e.getCommande().getElements_graphique().remove(e);
		elldao.deleteById(ide);
		return 1;
	}
	
	public int addelements(Element_ghraphique e) {
		elldao.save(e);
		return 1;
	}
	
	public int affecte_e_to_c (int ide ,int idc) {
		Commande c = comdao.findById(idc).get();
		Element_ghraphique e= elldao.findById(ide).get();
		c.getElements_graphique().add(e);
		e.setCommande(c);
		comdao.save(c);
		elldao.save(e);
		return 1 ;
	}
	public List<Element_ghraphique> getelementbycom(int idc){
		Commande c = comdao.findById(idc).get();
		List<Element_ghraphique>ees = new ArrayList<Element_ghraphique>();
		for(Element_ghraphique e : c.getElements_graphique()) {
			ees.add(e);
		}
		
		return ees;
	}
	
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
