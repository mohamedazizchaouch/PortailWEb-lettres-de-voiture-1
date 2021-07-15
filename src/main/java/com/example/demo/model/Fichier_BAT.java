package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Fichier_BAT {
	@Id
	@GeneratedValue 
	private int id;
	
	private String url_fichier ;
	@JsonIgnore
	@OneToOne(mappedBy = "fichier_BAT",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Commande commande ;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imprimeur_id")
	private Imprimeur imprimeur ;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "fichier_BAT",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER,orphanRemoval=true)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<Commentaire_BAT> commentaires_BAT ;
	
	
	
	
	public Set<Commentaire_BAT> getCommentaires_BAT() {
		return commentaires_BAT;
	}

	public void setCommentaires_BAT(Set<Commentaire_BAT> commentaires_BAT) {
		this.commentaires_BAT = commentaires_BAT;
	}



	public Imprimeur getImprimeur() {
		return imprimeur;
	}

	public void setImprimeur(Imprimeur imprimeur) {
		this.imprimeur = imprimeur;
	}

	public String getUrl_fichier() {
		return url_fichier;
	}

	public void setUrl_fichier(String url_fichier) {
		this.url_fichier = url_fichier;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fichier_BAT(String url_fichier, Commande commande, Imprimeur imprimeur ) {
		super();
		this.url_fichier = url_fichier;
		this.commande = commande;
		this.imprimeur =imprimeur;
	
	}

	public Fichier_BAT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
