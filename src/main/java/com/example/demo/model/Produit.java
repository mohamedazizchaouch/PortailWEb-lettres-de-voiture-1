package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	@Id
 private int id_produit ;
	
	private double prix_unitaire_HT ;
	private double frais_port ;
	private String nom_produit;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "produit",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Commande commande ;

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public double getPrix_unitaire_HT() {
		return prix_unitaire_HT;
	}

	public void setPrix_unitaire_HT(double prix_unitaire_HT) {
		this.prix_unitaire_HT = prix_unitaire_HT;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
	public double getFrais_port() {
		return frais_port;
	}

	public void setFrais_port(double frais_port) {
		this.frais_port = frais_port;
	}

	public Produit(int id_produit, double prix_unitaire_HT, double frais_port) {
		super();
		this.id_produit = id_produit;
		this.prix_unitaire_HT = prix_unitaire_HT;
		this.frais_port = frais_port;
		
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
