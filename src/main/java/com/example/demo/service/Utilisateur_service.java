package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.Admin_vente;
import com.example.demo.model.Client;
import com.example.demo.model.Imprimeur;
import com.example.demo.model.User;
import com.example.demo.model.Utilisateur;

@Service
public class Utilisateur_service {

	@Autowired
	private UtilisateurDao userdao ;
	
	
	public int updatepasword(int id,String mdp) {
		Utilisateur u = userdao.findById(id).get();
		u.setMdp(mdp);
		userdao.save(u);
		
		return 1;
		
	}
	public List<Utilisateur> getalluserss () {
	 List<Utilisateur> users =userdao.findAll();

		return users ; 
	}
	
	
	public User login (String mdp ,String login ) {
		List <Utilisateur> users = userdao.findAll();
		int i = 0 ;
		boolean p = true ;
	
		while ((i<users.size()) && (p==true) ) {
			
			
			if   (  (users.get(i).getLogin().equals(login))  &&  (users.get(i).getMdp().equals(mdp)) ) {
				if (users.get(i).getClass().getName().substring(23).equals("Client")) {
					p= false;
					Client c = (Client) users.get(i);
					User u = new User(c.getId(), c.getLogin(), c.getMdp(), c.getEmail(), c.getNum_Telephone(),c.getNum_Fax(), c.getCode_client(),
							c.getRaison_social(), c.getPersonne_a_contacter(), c.getAdresse_facturation(),
							c.getVille_adresse_facturation(), c.getRue_adresse_facturation(), c.getCode_postal_adresse_facturation(),
							c.getGouvernorat(),10
							
							);
					
					return u;
					
					
					
				} 
				
				if (users.get(i).getClass().getName().substring(23).equals("Imprimeur")) {
					p= false;
					Imprimeur ii = (Imprimeur) users.get(i);
					User u = new User(ii.getId(),ii.getLogin(),ii.getMdp(), ii.getEmail(), ii.getNum_Telephone(), ii.getNum_Fax(),20);
					return  u;
					
				} 
				
				if (users.get(i).getClass().getName().substring(23).equals("Admin_vente")) {
					Admin_vente a = (Admin_vente) users.get(i);
					User u = new User(a.getId(),a.getLogin(),a.getMdp(), a.getEmail(), a.getNum_Telephone(), a.getNum_Fax(),30);
					p= false;
					return  u;
					
				} 
					 
				
			}else{
				
				i++  ;
					}
		}
		return null ;
	}
}
