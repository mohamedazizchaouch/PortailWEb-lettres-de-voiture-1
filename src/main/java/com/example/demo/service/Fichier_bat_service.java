package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CommandeDao;
import com.example.demo.dao.CommentaireBatdao;
import com.example.demo.dao.Fichier_batDao;
import com.example.demo.dao.ImprimeurDao;
import com.example.demo.model.Commande;
import com.example.demo.model.Commentaire_BAT;
import com.example.demo.model.Etat_commande;
import com.example.demo.model.Fichier_BAT;
import com.example.demo.model.Imprimeur;

@Service
public class Fichier_bat_service {

	@Autowired
	private Fichier_batDao fichdao ;
	
	@Autowired
	private ImprimeurDao impdao;
	
	@Autowired
	private CommandeDao comdao;
	
	@Autowired
	private CommentaireBatdao cmmdao;
	
	//depot fichier bat
	public int createficherbat(Fichier_BAT f,int idimp, int idcom) {
		
		Commande c = comdao.findById(idcom).get();
		c.setEtat_commande(Etat_commande.Attente_validation_BAT);
		Imprimeur i = impdao.findById(idimp).get();
		c.setFichier_BAT(f);
		f.setImprimeur(i);
		i.getFichiers_BAT().add(f);
		f.setCommande(c);
		
		fichdao.save(f);
		impdao.save(i);
		comdao.save(c);
		return 1;
	}
	
	public List<Fichier_BAT>getfichbat_cmd(int idc){
		Commande c = comdao.findById(idc).get();
		List<Fichier_BAT> fs = new ArrayList<Fichier_BAT>();
		fs.add(c.getFichier_BAT());
		return fs ;
	}
	
	public int delete(int idimp ,int idcom ,int idf ) {
		Commande c = comdao.findById(idcom).get();
		
		Imprimeur i = impdao.findById(idimp).get();
		Fichier_BAT f = fichdao.findById(idf).get();
		c.setFichier_BAT(null);
		
		
		i.getFichiers_BAT().remove(f);
	//f.getCommentaires_BAT().clear();
	
		
		comdao.save(c);
impdao.save(i);

fichdao.deleteById(idf);
		
		return 1;
	}

	
}
