package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Imprimeur extends Utilisateur {
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Fichier_BAT> fichiers_BAT ;
	
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_BAT> commentaires_BAT ;
	
	@OneToMany(mappedBy = "imprimeur",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_commande> commentaire_commande ; 

	
	
	
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

	public Imprimeur(String login, String mdp, String email, int num_Telephone, int num_Fax,
			Set<Fichier_BAT> fichiers_BAT) {
		super(login, mdp, email, num_Telephone, num_Fax);
		this.fichiers_BAT = fichiers_BAT;
	}

	public Imprimeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imprimeur(String login, String mdp, String email, int num_Telephone, int num_Fax) {
		super(login, mdp, email, num_Telephone, num_Fax);
		// TODO Auto-generated constructor stub
	}

	
	

}
