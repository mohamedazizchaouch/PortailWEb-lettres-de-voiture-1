package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Element_ghraphique {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String url_element_graphique ;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "commande_id")
	private Commande commande ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl_element_graphique() {
		return url_element_graphique;
	}

	public void setUrl_element_graphique(String url_element_graphique) {
		this.url_element_graphique = url_element_graphique;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Element_ghraphique(String url_element_graphique, Commande commande) {
		super();
		this.url_element_graphique = url_element_graphique;
		this.commande = commande;
	}

	public Element_ghraphique() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
