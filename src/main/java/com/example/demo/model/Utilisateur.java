package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id ;
	private String Login ;
	private String Mdp ;
	private String Email ;
	private int num_Telephone ;
	private int num_Fax ;
	
	@Override
	public String toString() {
		return "Utilisateur [Id=" + Id + ", Login=" + Login + ", Mdp=" + Mdp + ", Email=" + Email + ", num_Telephone="
				+ num_Telephone + ", num_Fax=" + num_Fax + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getNum_Telephone() {
		return num_Telephone;
	}
	public void setNum_Telephone(int num_Telephone) {
		this.num_Telephone = num_Telephone;
	}
	public int getNum_Fax() {
		return num_Fax;
	}
	public void setNum_Fax(int num_Fax) {
		this.num_Fax = num_Fax;
	}
	public Utilisateur(String login, String mdp, String email, int num_Telephone, int num_Fax) {
		super();
		Login = login;
		Mdp = mdp;
		Email = email;
		this.num_Telephone = num_Telephone;
		this.num_Fax = num_Fax;
	}
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
