package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientDao;
import com.example.demo.dao.CommandeDao;
import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.Etat_commande;

@Service
public class Client_service {
@Autowired
private ClientDao clientdao ;

@Autowired
private CommandeDao commdao;
@Autowired
public JavaMailSender emailSender;

public int addClient ( Client c) {
	clientdao.save(c);
	return  1 ;
}

public String deleteClient(int id) {
	if (clientdao.findById(id).isPresent()) {
		clientdao.deleteById(id);
		return "client  supprimé";
	} else
		return "client t non supprimé";
}

public List<Client> getallClient () {
	
	return clientdao.findAll();

}
//commande en cours d'un client
public List<Commande> getcommandeclient_encours(int idcl ) {
	
	Client c = clientdao.findById(idcl).get();
	List<Commande>cc = new ArrayList<Commande>();

	for(Commande co : c.getCommande()) {
		if(co.getEtat_commande()!=Etat_commande.Livraison) {
		cc.add(co);}
		
	}
	return cc;
	
}
//Historique commande d'un client 
public List<Commande>getHistoriquecomm_client (int idcl){
	Client c = clientdao.findById(idcl).get();
	List<Commande>cc = new ArrayList<Commande>();

	for(Commande co : c.getCommande()) {
		if(co.getEtat_commande()==Etat_commande.Livraison) {
		cc.add(co);}
		
	}
	return cc;
	
	
}
//accepter bat
 public int accepterbat(int idc ) {
	 Commande c = commdao.findById(idc).get();
	 c.setEtat_commande(Etat_commande.BAT_accepter);
	 commdao.save(c);
	 return 1;
 }
 
 public int refuserbat(int idc ) {
	 Commande c = commdao.findById(idc).get();
	 c.setEtat_commande(Etat_commande.Bat_refuser);
	 commdao.save(c);
	 SimpleMailMessage message = new SimpleMailMessage();
     
     message.setTo("mohamedaziz.chaouch@esprit.tn");
     message.setSubject("Test Simple Email");
     message.setText("Hello, Im testing Simple Email");

     // Send Message!
     this.emailSender.send(message);
	 return 1;
 }

}
