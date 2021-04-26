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
public class Commentaire_BAT {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_commentaire ;
	
	private String text_commentaire ;
	
	private  Date date_heure_commentaire ;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client ;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imprimeur_id")
	private Imprimeur imprimeur ;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fichierBAT_id")
	private Fichier_BAT fichier_BAT ;

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Imprimeur getImprimeur() {
		return imprimeur;
	}

	public void setImprimeur(Imprimeur imprimeur) {
		this.imprimeur = imprimeur;
	}

	public Fichier_BAT getFichier_BAT() {
		return fichier_BAT;
	}

	public void setFichier_BAT(Fichier_BAT fichier_BAT) {
		this.fichier_BAT = fichier_BAT;
	}

	public Commentaire_BAT(String text_commentaire, Date date_heure_commentaire, Client client, Imprimeur imprimeur,
			Fichier_BAT fichier_BAT) {
		super();
		this.text_commentaire = text_commentaire;
		this.date_heure_commentaire = date_heure_commentaire;
		this.client = client;
		this.imprimeur = imprimeur;
		this.fichier_BAT = fichier_BAT;
	}

	public Commentaire_BAT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
