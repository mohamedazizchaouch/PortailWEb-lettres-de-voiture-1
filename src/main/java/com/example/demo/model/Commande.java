package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.dao.stats;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int num_commande ;
	private Date date_creation_dossier ;
	private Date date_commande ;
	private String ref_commercial ;
	private int quntite ;
	private double prix_achat_HT;
	private double prix_vente_HT ;
	private double frais_transport_achat_HT;
	private String text_a_repliquer ;
	@Enumerated(EnumType.STRING)
	private Etat_commande etat_commande;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="admin_vente_ID")
	private Admin_vente admin_vente;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ref_produit")
	private Produit produit ;
	
	@OneToOne(mappedBy = "commande",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Facture facture ;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ref_fichier_bat")
	private Fichier_BAT fichier_BAT ;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imprimeur_id")
	private Imprimeur imprimeur ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "commande",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Commentaire_commande> commentaire_commande ;
	
	@OneToMany(mappedBy = "commande",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Element_ghraphique> elements_graphique ;
	
	public Commande(String nom_produit ,long count) {
		ref_commercial= nom_produit;
		num_commande =(int) count;
		
				
		
	}
	
	
	
	public Facture getFacture() {
		return facture;
	}



	public void setFacture(Facture facture) {
		this.facture = facture;
	}



	public Imprimeur getImprimeur() {
		return imprimeur;
	}



	public void setImprimeur(Imprimeur imprimeur) {
		this.imprimeur = imprimeur;
	}



	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Element_ghraphique> getElements_graphique() {
		return elements_graphique;
	}
	public void setElements_graphique(Set<Element_ghraphique> elements_graphique) {
		this.elements_graphique = elements_graphique;
	}
	public Set<Commentaire_commande> getCommentaire_commande() {
		return commentaire_commande;
	}
	public void setCommentaire_commande(Set<Commentaire_commande> commentaire_commande) {
		this.commentaire_commande = commentaire_commande;
	}
	public Fichier_BAT getFichier_BAT() {
		return fichier_BAT;
	}
	public void setFichier_BAT(Fichier_BAT fichier_BAT) {
		this.fichier_BAT = fichier_BAT;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Admin_vente getAdmin_vente() {
		return admin_vente;
	}
	public void setAdmin_vente(Admin_vente admin_vente) {
		this.admin_vente = admin_vente;
	}
	public int getNum_commande() {
		return num_commande;
	}
	public void setNum_commande(int num_commande) {
		this.num_commande = num_commande;
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
	public Etat_commande getEtat_commande() {
		return etat_commande;
	}
	public void setEtat_commande(Etat_commande etat_commande) {
		this.etat_commande = etat_commande;
	}
	
	
	
	public Commande(Date date_creation_dossier, Date date_commande, String ref_commercial, int quntite,
			double prix_achat_HT, double prix_vente_HT, double frais_transport_achat_HT, String text_a_repliquer,
			Etat_commande etat_commande, Admin_vente admin_vente, Produit produit , Fichier_BAT fichier_BAT) {
		super();
		this.date_creation_dossier = date_creation_dossier;
		this.date_commande = date_commande;
		this.ref_commercial = ref_commercial;
		this.quntite = quntite;
		this.prix_achat_HT = prix_achat_HT;
		this.prix_vente_HT = prix_vente_HT;
		this.frais_transport_achat_HT = frais_transport_achat_HT;
		this.text_a_repliquer = text_a_repliquer;
		this.etat_commande = etat_commande;
		this.admin_vente = admin_vente;
		this.fichier_BAT =fichier_BAT ;
		this.produit=produit;
	}
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
