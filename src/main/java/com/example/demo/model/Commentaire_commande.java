package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commentaire_commande {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_commentaire ;
	
	private String text_commentaire ;
	
	private  Date date_heure_commentaire ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "admin_vente_id")
	private Admin_vente admin_vente ;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imprimeur_id")
	private Imprimeur imprimeur ;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commande_id")
	private Commande commande ;

	public int getId_commentaire() {
		return id_commentaire;
	}

	public void setId_commentaire(int id_commentaire) {
		this.id_commentaire = id_commentaire;
	}

	public String getText_commentaire() {
		return text_commentaire;
	}

	public void setText_commentaire(String text_commentaire) {
		this.text_commentaire = text_commentaire;
	}

	public Date getDate_heure_commentaire() {
		return date_heure_commentaire;
	}

	public void setDate_heure_commentaire(Date date_heure_commentaire) {
		this.date_heure_commentaire = date_heure_commentaire;
	}

	public Admin_vente getAdmin_vente() {
		return admin_vente;
	}

	public void setAdmin_vente(Admin_vente admin_vente) {
		this.admin_vente = admin_vente;
	}

	public Imprimeur getImprimeur() {
		return imprimeur;
	}

	public void setImprimeur(Imprimeur imprimeur) {
		this.imprimeur = imprimeur;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Commentaire_commande(String text_commentaire, Date date_heure_commentaire, Admin_vente admin_vente,
			Imprimeur imprimeur, Commande commande) {
		super();
		this.text_commentaire = text_commentaire;
		this.date_heure_commentaire = date_heure_commentaire;
		this.admin_vente = admin_vente;
		this.imprimeur = imprimeur;
		this.commande = commande;
	}

	public Commentaire_commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
