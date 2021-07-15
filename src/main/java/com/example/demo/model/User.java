package com.example.demo.model;

public class User {
	private int Id ;
	private String Login ;
	private String Mdp ;
	private String Email ;
	private int num_Telephone ;
	private int num_Fax ;
	private String code_client ;
	private String raison_social;
	private String personne_a_contacter ;
	private String adresse_facturation ;
	private String ville_adresse_facturation; 
	private String rue_adresse_facturation;
	private String code_postal_adresse_facturation;
	private String gouvernorat ;
	private int type_user ;
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
	public String getCode_client() {
		return code_client;
	}
	public void setCode_client(String code_client) {
		this.code_client = code_client;
	}
	public String getRaison_social() {
		return raison_social;
	}
	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}
	public String getPersonne_a_contacter() {
		return personne_a_contacter;
	}
	public void setPersonne_a_contacter(String personne_a_contacter) {
		this.personne_a_contacter = personne_a_contacter;
	}
	public String getAdresse_facturation() {
		return adresse_facturation;
	}
	public void setAdresse_facturation(String adresse_facturation) {
		this.adresse_facturation = adresse_facturation;
	}
	public String getVille_adresse_facturation() {
		return ville_adresse_facturation;
	}
	public void setVille_adresse_facturation(String ville_adresse_facturation) {
		this.ville_adresse_facturation = ville_adresse_facturation;
	}
	public String getRue_adresse_facturation() {
		return rue_adresse_facturation;
	}
	public void setRue_adresse_facturation(String rue_adresse_facturation) {
		this.rue_adresse_facturation = rue_adresse_facturation;
	}
	public String getCode_postal_adresse_facturation() {
		return code_postal_adresse_facturation;
	}
	public void setCode_postal_adresse_facturation(String code_postal_adresse_facturation) {
		this.code_postal_adresse_facturation = code_postal_adresse_facturation;
	}
	public String getGouvernorat() {
		return gouvernorat;
	}
	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}
	public int getType_user() {
		return type_user;
	}
	public void setType_user(int type_user) {
		this.type_user = type_user;
	}
	public User(int id, String login, String mdp, String email, int num_Telephone, int num_Fax, String code_client,
			String raison_social, String personne_a_contacter, String adresse_facturation,
			String ville_adresse_facturation, String rue_adresse_facturation, String code_postal_adresse_facturation,
			String gouvernorat, int type_user) {
		super();
		Id = id;
		Login = login;
		Mdp = mdp;
		Email = email;
		this.num_Telephone = num_Telephone;
		this.num_Fax = num_Fax;
		this.code_client = code_client;
		this.raison_social = raison_social;
		this.personne_a_contacter = personne_a_contacter;
		this.adresse_facturation = adresse_facturation;
		this.ville_adresse_facturation = ville_adresse_facturation;
		this.rue_adresse_facturation = rue_adresse_facturation;
		this.code_postal_adresse_facturation = code_postal_adresse_facturation;
		this.gouvernorat = gouvernorat;
		this.type_user = type_user;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id,String login, String mdp, String email, int num_Telephone, int num_Fax, int type_user) {
		super();
		Id = id;
		Login = login;
		Mdp = mdp;
		Email = email;
		this.num_Telephone = num_Telephone;
		this.num_Fax = num_Fax;
		this.type_user= type_user;
	}
	
	
	
	
}
