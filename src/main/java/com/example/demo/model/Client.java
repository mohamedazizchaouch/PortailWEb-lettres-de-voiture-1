package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Client extends Utilisateur {
	private String code_client ;
	private String raison_social;
	private String personne_a_contacter ;
	private String adresse_facturation ;
	private String adresse_livraison;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commande> commande ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_BAT> commentaires_BAT ;
	
	
	
	public Set<Commentaire_BAT> getCommentaires_BAT() {
		return commentaires_BAT;
	}
	public void setCommentaires_BAT(Set<Commentaire_BAT> commentaires_BAT) {
		this.commentaires_BAT = commentaires_BAT;
	}
	
	
	
	public Set<Commande> getCommande() {
		return commande;
	}
	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}
	public String getCode_client() {
		return code_client;
	}
	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}
	public String getRaison_social() {
		return raison_social;
	}
	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}
	public String getPersonne_a_contacter() {
		return personne_a_contacter;
	}
	public void setPersonne_a_contacter(String personne_a_contacter) {
		this.personne_a_contacter = personne_a_contacter;
	}
	public String getAdresse_facturation() {
		return adresse_facturation;
	}
	public void setAdresse_facturation(String adresse_facturation) {
		this.adresse_facturation = adresse_facturation;
	}
	public String getAdresse_livraison() {
		return adresse_livraison;
	}
	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}
	public Client (String code_client,String  raison_social) {
		this.code_client=code_client;
		this.raison_social=raison_social;
	 
	}
	public Client(String login, String mdp, String email, int num_Telephone, int num_Fax, String code_client,
			String raison_social, String personne_a_contacter, String adresse_facturation, String adresse_livraison) {
		super(login, mdp, email, num_Telephone, num_Fax);
		this.code_client = code_client;
		this.raison_social = raison_social;
		this.personne_a_contacter = personne_a_contacter;
		this.adresse_facturation = adresse_facturation;
		this.adresse_livraison = adresse_livraison;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String login, String mdp, String email, int num_Telephone, int num_Fax) {
		super(login, mdp, email, num_Telephone, num_Fax);
		// TODO Auto-generated constructor stub
	}

	

	
	

}
