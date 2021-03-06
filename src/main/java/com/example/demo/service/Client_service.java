package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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

public Client getclient_byid(int id) {
	return clientdao.findById(id).get();
}

public int activate(int idc) {
	Client c= clientdao.findById(idc).get();
	c.setEtat(true);
	clientdao.save(c);
	return 1;
}


public Client updateaddf(int idc ,Client nc) {
	Client c=clientdao.findById(idc).get();
	c.setAdresse_facturation(nc.getAdresse_facturation());
	c.setGouvernorat(nc.getGouvernorat());
	c.setVille_adresse_facturation(nc.getVille_adresse_facturation());
	c.setRue_adresse_facturation(nc.getRue_adresse_facturation());
	c.setCode_postal_adresse_facturation(nc.getCode_postal_adresse_facturation());
	clientdao.save(c);
	return c ;
	
	
}
public int count_cmdencous(int idclt) {
	Client c=clientdao.findById(idclt).get();
	List<Commande>cmds = new ArrayList<Commande>();
	for(Commande cmd : c.getCommande()) {
		if((cmd.getEtat_commande()==Etat_commande.BAT_accepter)||(cmd.getEtat_commande()==Etat_commande.Bat_refuser)||
				(cmd.getEtat_commande()==Etat_commande.Attente_validation_BAT)||	(cmd.getEtat_commande()==Etat_commande.Encours_BAT)||(cmd.getEtat_commande()==Etat_commande.Modification_BAT)) {
			cmds.add(cmd);
		}
		
	}
	return cmds.size();
}
public int commande_encours_client(int idclt) {
	Client c=clientdao.findById(idclt).get();
	int i = 0 ;
	boolean p = true ;
	List<Commande>cmds = new ArrayList<Commande>();
for(Commande cmd : c.getCommande()) {
	cmds.add(cmd);
}
while ((p==true)&&(i<cmds.size())) {
	if((cmds.get(i).getEtat_commande()==Etat_commande.Encours_BAT)||(cmds.get(i).getEtat_commande()==Etat_commande.Attente_validation_BAT)||
			(cmds.get(i).getEtat_commande()==Etat_commande.Bat_refuser)||(cmds.get(i).getEtat_commande()==Etat_commande.BAT_accepter)||
			(cmds.get(i).getEtat_commande()==Etat_commande.Modification_BAT)) {
		p =false;
		return 10;
	}else {
		i++;
	}
}
		
	return 1 ;
}
public Client updateaddl(int idc ,Client nc) {
	Client c=clientdao.findById(idc).get();
	c.setAdresse_livraison(nc.getAdresse_livraison());
	c.setGovvernorat_liv(nc.getGovvernorat_liv());
	c.setVille_adresse_facturation_liv(nc.getVille_adresse_facturation_liv());
	c.setRue_adresse_facturation_liv(nc.getRue_adresse_facturation_liv());
	c.setCode_postal_adresse_liv(nc.getCode_postal_adresse_liv());
	clientdao.save(c);
	
	return c;
}

public int addClient ( Client c) {
	Random ran= new Random();
	int nb ;
	nb=100000+ran.nextInt(999999-100000);
	String mdp ="C_mdp"+nb;
	c.setMdp(mdp);
	clientdao.save(c);
	String to=c.getEmail();
	String from="pfe.itsterone@gmail.com";
	String smtpHost = "smtp.gmail.com"; //replace this with a valid host
    int smtpPort = 587; //replace this with a valid port
    
    Properties properties = new Properties();
    properties.put("mail.smtp.host", smtpHost);
    properties.put("mail.smtp.port", smtpPort);    
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.debug", "true");



  Session session = Session.getDefaultInstance(properties, new Authenticator() {
        protected PasswordAuthentication  getPasswordAuthentication() {
        return new PasswordAuthentication(
                    "pfe.itsterone@gmail.com", "az147852369iz");
                }
    } );
  String url="http://localhost:1919/api/client/act/"+c.getId();
  try {
	  MimeMessage message = new MimeMessage(session);
	  message.setFrom(new InternetAddress(from));
	  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));;
	  message.setSubject("Portail_web_creation_compte Client!");
	  message.setContent("<h1>Portail web vente des lettres de voiture</h1>"
	  		+ "<p>Votre compte Client a ??t?? creer avec succes </p>"
	  		+ "<p> Votre mot de passe actuelle est:</p>"
	  		+mdp
	  		+ "<p>Pour activer votre compte <a  href=\""+url+"\" > cliquer ici <a/>  </p>"
	  		+ "<p>Bonne reception</p>"
	  	
	  		
	  		,"text/html");
	  Transport.send(message);
	  System.out.println("doneee ");
  }catch(MessagingException mex) {
	  mex.printStackTrace();
  }



	
	return  1 ;
}

public String deleteClient(int id) {
	if (clientdao.findById(id).isPresent()) {
		clientdao.deleteById(id);
		return "client  supprim??";
	} else
		return "client t non supprim??";
}

public List<Client> getallClient () {
	
	return clientdao.findAll();

}
//dernier cmd 
public Commande last_cmd(int idcl) {
	Client c = clientdao.findById(idcl).get();
	
	List<Commande>cc = new ArrayList<Commande>();
	for(Commande co : c.getCommande()) {
		if((co.getEtat_commande()==Etat_commande.Encours_BAT)||(co.getEtat_commande()==Etat_commande.Attente_validation_BAT)||
				(co.getEtat_commande()==Etat_commande.Modification_BAT)||(co.getEtat_commande()==Etat_commande.BAT_accepter)||
				(co.getEtat_commande()==Etat_commande.Bat_refuser)||(co.getEtat_commande()==Etat_commande.Impression)) {
		cc.add(co);}
		
	}
	Commande nc = cc.get(0);
	
	for(int i=1;i<cc.size();i++) {
		if(nc.getDate_commande().compareTo(cc.get(i).getDate_commande())== -1) {
			nc=cc.get(i);
		}
		
	}
	if(cc.size()==0) {
		return null;
	}
	return nc;
	

}
//commande en cours d'un client
public Commande getcommandeclient_encours(int idcl ) {
	
	Client c = clientdao.findById(idcl).get();
	List<Commande>cc = new ArrayList<Commande>();

	for(Commande co : c.getCommande()) {
		if((co.getEtat_commande()==Etat_commande.Encours_BAT)||(co.getEtat_commande()==Etat_commande.Attente_validation_BAT)||
				(co.getEtat_commande()==Etat_commande.Modification_BAT)||(co.getEtat_commande()==Etat_commande.BAT_accepter)||
				(co.getEtat_commande()==Etat_commande.Bat_refuser)) {
		cc.add(co);}
		
	}
	if(cc.size()==0) {
		return null;
	}
	return cc.get(0);
	
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
     
     message.setTo(c.getFichier_BAT().getImprimeur().getEmail());
     message.setSubject("Information Commande "+c.getNum_commande());
    message.setText("le fichier-bat de la commande "+c.getNum_commande()+" a ??t?? refuser .\n merci bien de consulter la commande et de rectifier les erreurs ");

    // Send Message!
    this.emailSender.send(message);
	 return 1;
 }

}
