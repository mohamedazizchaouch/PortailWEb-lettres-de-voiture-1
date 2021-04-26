package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Facture {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_facture ;

private Date date_creation_dossier ;
private Date date_commande ;
private String ref_commercial ;
private int quntite ;
private double prix_achat_HT;
private double prix_vente_HT ;
private double frais_transport_achat_HT;
private String text_a_repliquer ;




@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "commande_id")
private Commande commande ;

public int getId_facture() {
	return id_facture;
}
public void setId_facture(int id_facture) {
	this.id_facture = id_facture;
}
public Date getDate_creation_dossier() {
	return date_creation_dossier;
}
public void setDate_creation_dossier(Date date_creation_dossier) {
	this.date_creation_dossier = date_creation_dossier;
}
public Date getDate_commande() {
	return date_commande;
}
public void setDate_commande(Date date_commande) {
	this.date_commande = date_commande;
}
public String getRef_commercial() {
	return ref_commercial;
}
public void setRef_commercial(String ref_commercial) {
	this.ref_commercial = ref_commercial;
}
public int getQuntite() {
	return quntite;
}
public void setQuntite(int quntite) {
	this.quntite = quntite;
}
public double getPrix_achat_HT() {
	return prix_achat_HT;
}
public void setPrix_achat_HT(double prix_achat_HT) {
	this.prix_achat_HT = prix_achat_HT;
}
public double getPrix_vente_HT() {
	return prix_vente_HT;
}
public void setPrix_vente_HT(double prix_vente_HT) {
	this.prix_vente_HT = prix_vente_HT;
}
public double getFrais_transport_achat_HT() {
	return frais_transport_achat_HT;
}
public void setFrais_transport_achat_HT(double frais_transport_achat_HT) {
	this.frais_transport_achat_HT = frais_transport_achat_HT;
}
public String getText_a_repliquer() {
	return text_a_repliquer;
}
public void setText_a_repliquer(String text_a_repliquer) {
	this.text_a_repliquer = text_a_repliquer;
}
public Facture(int id_facture, Date date_creation_dossier, Date date_commande, String ref_commercial, int quntite,
		double prix_achat_HT, double prix_vente_HT, double frais_transport_achat_HT, String text_a_repliquer) {
	super();
	this.id_facture = id_facture;
	this.date_creation_dossier = date_creation_dossier;
	this.date_commande = date_commande;
	this.ref_commercial = ref_commercial;
	this.quntite = quntite;
	this.prix_achat_HT = prix_achat_HT;
	this.prix_vente_HT = prix_vente_HT;
	this.frais_transport_achat_HT = frais_transport_achat_HT;
	this.text_a_repliquer = text_a_repliquer;
}
public Facture() {
	super();
	// TODO Auto-generated constructor stub
}


	
	

}
