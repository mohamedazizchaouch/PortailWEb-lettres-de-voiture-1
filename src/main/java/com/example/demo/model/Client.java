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
	private String ville_adresse_facturation; 
	private String rue_adresse_facturation;
	private String code_postal_adresse_facturation;
	private String gouvernorat ;
private String pays_facturation ;
	private String ville_adresse_facturation_liv; 
	private String rue_adresse_facturation_liv;
	private String code_postal_adresse_liv;
	private String govvernorat_liv ;
	private String pays_liv ;
	
	
	
	
	public String getPays_facturation() {
		return pays_facturation;
	}
	public void setPays_facturation(String pays_facturation) {
		this.pays_facturation = pays_facturation;
	}
	public String getPays_liv() {
		return pays_liv;
	}
	public void setPays_liv(String pays_liv) {
		this.pays_liv = pays_liv;
	}
	public String getVille_adresse_facturation_liv() {
		return ville_adresse_facturation_liv;
	}
	public void setVille_adresse_facturation_liv(String ville_adresse_facturation_liv) {
		this.ville_adresse_facturation_liv = ville_adresse_facturation_liv;
	}
	public String getRue_adresse_facturation_liv() {
		return rue_adresse_facturation_liv;
	}
	public void setRue_adresse_facturation_liv(String rue_adresse_facturation_liv) {
		this.rue_adresse_facturation_liv = rue_adresse_facturation_liv;
	}
	public String getCode_postal_adresse_liv() {
		return code_postal_adresse_liv;
	}
	public void setCode_postal_adresse_liv(String code_postal_adresse_liv) {
		this.code_postal_adresse_liv = code_postal_adresse_liv;
	}
	public String getGovvernorat_liv() {
		return govvernorat_liv;
	}
	public void setGovvernorat_liv(String govvernorat_liv) {
		this.govvernorat_liv = govvernorat_liv;
	}
	public String getVille_adresse_facturation() {
		return ville_adresse_facturation;
	}
	public void setVille_adresse_facturation(String ville_adresse_facturation) {
		this.ville_adresse_facturation = ville_adresse_facturation;
	}
	public String getRue_adresse_facturation() {
		return rue_adresse_facturation;
	}
	public void setRue_adresse_facturation(String rue_adresse_facturation) {
		this.rue_adresse_facturation = rue_adresse_facturation;
	}
	public String getCode_postal_adresse_facturation() {
		return code_postal_adresse_facturation;
	}
	public void setCode_postal_adresse_facturation(String code_postal_adresse_facturation) {
		this.code_postal_adresse_facturation = code_postal_adresse_facturation;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
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
	
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String login, String mdp, String email, int num_Telephone, boolean etat, int num_Fax,
			String code_client, String raison_social, String personne_a_contacter, String adresse_facturation,
			String ville_adresse_facturation, String rue_adresse_facturation, String code_postal_adresse_facturation,
			String gouvernorat, String pays_facturation, String ville_adresse_facturation_liv,
			String rue_adresse_facturation_liv, String code_postal_adresse_liv, String govvernorat_liv, String pays_liv,
			String adresse_livraison, Set<Commande> commande, Set<Commentaire_BAT> commentaires_BAT) {
		super(id, login, mdp, email, num_Telephone, etat, num_Fax);
		this.code_client = code_client;
		this.raison_social = raison_social;
		this.personne_a_contacter = personne_a_contacter;
		this.adresse_facturation = adresse_facturation;
		this.ville_adresse_facturation = ville_adresse_facturation;
		this.rue_adresse_facturation = rue_adresse_facturation;
		this.code_postal_adresse_facturation = code_postal_adresse_facturation;
		this.gouvernorat = gouvernorat;
		this.pays_facturation = pays_facturation;
		this.ville_adresse_facturation_liv = ville_adresse_facturation_liv;
		this.rue_adresse_facturation_liv = rue_adresse_facturation_liv;
		this.code_postal_adresse_liv = code_postal_adresse_liv;
		this.govvernorat_liv = govvernorat_liv;
		this.pays_liv = pays_liv;
		this.adresse_livraison = adresse_livraison;
		this.commande = commande;
		this.commentaires_BAT = commentaires_BAT;
	}

	
	

	
	

}
