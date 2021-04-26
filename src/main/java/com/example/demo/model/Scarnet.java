package com.example.demo.model;

public class Scarnet {
	private long nbr_carnet;
	private String nom_produit ;
	public Scarnet(long nbr_carnet, String nom_produit) {
		super();
		this.nbr_carnet = nbr_carnet;
		this.nom_produit = nom_produit;
	}
	public long getNbr_carnet() {
		return nbr_carnet;
	}
	public void setNbr_carnet(long nbr_carnet) {
		this.nbr_carnet = nbr_carnet;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	
	

}
