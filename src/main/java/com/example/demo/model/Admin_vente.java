package com.example.demo.model;

import java.nio.MappedByteBuffer;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Admin_vente extends Utilisateur {
	
	@OneToMany(mappedBy = "admin_vente",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commande> commandes ;
	
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

	public Admin_vente(String login, String mdp, String email, int num_Telephone, int num_Fax, Set commandes) {
		super(login, mdp, email, num_Telephone, num_Fax);
		this.commandes = commandes;
	}

	public Admin_vente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin_vente(String login, String mdp, String email, int num_Telephone, int num_Fax) {
		super(login, mdp, email, num_Telephone, num_Fax);
		// TODO Auto-generated constructor stub
	}

	
	

}
