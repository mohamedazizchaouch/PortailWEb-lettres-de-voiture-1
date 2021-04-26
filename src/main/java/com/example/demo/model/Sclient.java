package com.example.demo.model;

public class Sclient {
	private String nom;
	private long count;
	
	public Sclient(String nom ,long count) {
		this.nom=nom;
		this.count=count ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	

}
