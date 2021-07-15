package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CommentaireBatdao;
import com.example.demo.dao.Fichier_batDao;
import com.example.demo.dao.ImprimeurDao;
import com.example.demo.model.Client;
import com.example.demo.model.Commentaire_BAT;
import com.example.demo.model.Etat_commande;
import com.example.demo.model.Fichier_BAT;
import com.example.demo.model.Imprimeur;

@Service
public class commentaireBat_service {
	
	@Autowired
	private CommentaireBatdao cdao ;
	@Autowired
	private ClientDao cldao ;
	@Autowired
	private Fichier_batDao fdao ;
	@Autowired
	private ImprimeurDao idao  ;
	
	
public int deletecomm (int id) {
		cdao.deleteById(id);
		return 1;
		
	}
	
	public int ajouter_commentaire_client(int idcl , int idf,Commentaire_BAT c) {
		Client cl = cldao.findById(idcl).get();
		Fichier_BAT f =fdao.findById(idf).get();
		cl.getCommentaires_BAT().add(c);
		f.getCommentaires_BAT().add(c);
		c.setClient(cl);
		c.setFichier_BAT(f);
		cdao.save(c);
		fdao.save(f);
		cldao.save(cl);
		return 1;
	}
	
	public int ajouter_commentaire_imprimeur(int idi ,int idf ,Commentaire_BAT c) {
		Imprimeur i = idao.findById(idi).get();
		Fichier_BAT f = fdao.findById(idf).get();
		i.getCommentaires_BAT().add(c);
		f.getCommentaires_BAT().add(c);
		c.setImprimeur(i);
		c.setFichier_BAT(f);
	f.getCommande().setEtat_commande(Etat_commande.Modification_BAT);
		cdao.save(c);
		fdao.save(f);
		idao.save(i);
		
		
		
		return 1;
	}
	
	
	public List<Commentaire_BAT> getcomms_by_fich_bat(int idf) {
		List<Commentaire_BAT> cms = new ArrayList<Commentaire_BAT>();
		for(Commentaire_BAT c : cdao.findAll()) {
			if(c.getFichier_BAT().getId()==idf) {
				cms.add(c);
				
			}
		}
		return cms ;
	}
	
	public int deletecmmsbyfich(int idf) {
		Fichier_BAT f = fdao.findById(idf).get();
		List<Commentaire_BAT> cms = new ArrayList<Commentaire_BAT>();
		for(Commentaire_BAT c : cdao.findAll()) {
			if(c.getFichier_BAT().getId()==idf) {
				f.getCommentaires_BAT().remove(c);
				fdao.save(f);
				c.setFichier_BAT(null);
				if(c.getImprimeur()!= null) {
					c.getImprimeur().getCommentaires_BAT().remove(c);
					c.setImprimeur(null);
				}
				
				if (c.getClient()!=null) {
					c.getClient().getCommentaires_BAT().remove(c);
					c.setClient(null);
				}
				
				
				
				cdao.delete(c);
				
			}
		}
		return 1;
	}
	
	

}
