package com.example.demo.model;

import java.nio.MappedByteBuffer;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Admin_vente extends Utilisateur {
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin_vente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commande> commandes ;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin_vente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_commande> commentaire_commande ;

	
	
	

	public Set<Commentaire_commande> getCommentaire_commande() {
		return commentaire_commande;
	}

	public void setCommentaire_commande(Set<Commentaire_commande> commentaire_commande) {
		this.commentaire_commande = commentaire_commande;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	
	public Admin_vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin_vente(int id, String login, String mdp, String email, int num_Telephone, boolean etat, int num_Fax,
			Set<Commande> commandes, Set<Commentaire_commande> commentaire_commande) {
		super(id, login, mdp, email, num_Telephone, etat, num_Fax);
		this.commandes = commandes;
		this.commentaire_commande = commentaire_commande;
	}



	
	

}
