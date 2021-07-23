package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Imprimeur extends Utilisateur {
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Fichier_BAT> fichiers_BAT ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_BAT> commentaires_BAT ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_commande> commentaire_commande ; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commande> commande ;

	
	private String Contact_imp ;
	
	
	
	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}

	public String getContact_imp() {
		return Contact_imp;
	}

	public void setContact_imp(String contact_imp) {
		Contact_imp = contact_imp;
	}

	public Set<Commentaire_commande> getCommentaire_commande() {
		return commentaire_commande;
	}

	public void setCommentaire_commande(Set<Commentaire_commande> commentaire_commande) {
		this.commentaire_commande = commentaire_commande;
	}

	public Set<Commentaire_BAT> getCommentaires_BAT() {
		return commentaires_BAT;
	}

	public void setCommentaires_BAT(Set<Commentaire_BAT> commentaires_BAT) {
		this.commentaires_BAT = commentaires_BAT;
	}

	public Set<Fichier_BAT> getFichiers_BAT() {
		return fichiers_BAT;
	}

	public void setFichiers_BAT(Set<Fichier_BAT> fichiers_BAT) {
		this.fichiers_BAT = fichiers_BAT;
	}

	
	public Imprimeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imprimeur(int id, String login, String mdp, String email, int num_Telephone, boolean etat, int num_Fax,
			Set<Fichier_BAT> fichiers_BAT, Set<Commentaire_BAT> commentaires_BAT,
			Set<Commentaire_commande> commentaire_commande, Set<Commande> commande, String contact_imp) {
		super(id, login, mdp, email, num_Telephone, etat, num_Fax);
		this.fichiers_BAT = fichiers_BAT;
		this.commentaires_BAT = commentaires_BAT;
		this.commentaire_commande = commentaire_commande;
		this.commande = commande;
		Contact_imp = contact_imp;
	}

	

	

	
	

}
