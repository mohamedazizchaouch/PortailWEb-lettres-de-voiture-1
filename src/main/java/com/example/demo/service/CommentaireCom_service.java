package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Admin_venteDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.CommentaireComDao;
import com.example.demo.dao.ImprimeurDao;
import com.example.demo.model.Admin_vente;
import com.example.demo.model.Commande;
import com.example.demo.model.Commentaire_commande;
import com.example.demo.model.Imprimeur;

@Service
public class CommentaireCom_service {
	
	@Autowired 
	private CommentaireComDao ccdao ;
	@Autowired
	private ImprimeurDao idao ;
	
	@Autowired
	private CommandeDao cdao ;
	@Autowired
	private Admin_venteDao adao ;
	
	public int ajouter_commenttaire_imprimeur(Commentaire_commande c ,int idi ,int idc ) {
		Imprimeur I = idao.findById(idi).get();
		Commande co = cdao.findById(idc).get();
		I.getCommentaire_commande().add(c);
		co.getCommentaire_commande().add(c);
		
		c.setCommande(co);
		c.setImprimeur(I);
		ccdao.save(c);
		idao.save(I);
		cdao.save(co);
		
		return 1;
	}
	public int ajouter_commentaire_admin(Commentaire_commande c , int ida ,int idc) {
		Admin_vente a = adao.findById(ida).get();
		Commande co = cdao.findById(idc).get();
		a.getCommentaire_commande().add(c);
		co.getCommentaire_commande().add(c);
		c.setAdmin_vente(a);
		c.setCommande(co);
		ccdao.save(c);
		adao.save(a);
		cdao.save(co);
		return 1;
	}
	public List<Commentaire_commande>get_comm_by_commande(int idc){
		Commande c = cdao.findById(idc).get();
		List<Commentaire_commande>ccs = new ArrayList<Commentaire_commande>();
		for(Commentaire_commande cc : c.getCommentaire_commande()) {
			ccs.add(cc);
		}
		return ccs ;
		
		
	}
}
