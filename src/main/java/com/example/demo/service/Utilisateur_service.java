package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UtilisateurDao;
import com.example.demo.model.Client;
import com.example.demo.model.Utilisateur;

@Service
public class Utilisateur_service {

	@Autowired
	private UtilisateurDao userdao ;
	
	public List<Utilisateur> getalluserss () {
	 List<Utilisateur> users =userdao.findAll();

		return users ; 
	}
	
	public int login (String mdp ,String login ) {
		List <Utilisateur> users = userdao.findAll();
		int i = 0 ;
		boolean p = true ;
		while ((i<users.size()) && (p==true) ) {
			
			
			if   (  (users.get(i).getLogin().equals(login))  &&  (users.get(i).getMdp().equals(mdp)) ) {
				if (users.get(i).getClass().getName().substring(23).equals("Client")) {
					p= false;
					return 10;
					
				} 
				
				if (users.get(i).getClass().getName().substring(23).equals("Imprimeur")) {
					p= false;
					return 20;
					
				} 
				
				if (users.get(i).getClass().getName().substring(23).equals("Admin_vente")) {
					p= false;
					return 30;
					
				} 
					 
				
			}else{
				
				i++  ;
					}
		}
		return 0 ;
	}
}
