package com.example.demo.model;

import com.example.demo.dao.stats;

public class Cl  {
	private long count ;
	private String nom_produit;
	public Cl(String nom_produit,long count) {
		
		this.count = count;
		this.nom_produit = nom_produit;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	
	

   
}
