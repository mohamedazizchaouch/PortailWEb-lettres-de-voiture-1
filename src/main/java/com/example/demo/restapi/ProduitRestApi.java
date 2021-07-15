package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produit;
import com.example.demo.service.Produit_service;

@RestController
@RequestMapping(value = "/api/produit")
public class ProduitRestApi {
	
	@Autowired
	private Produit_service ps ;
	
	
	
	
	@GetMapping(value = "/{id}")
	public Produit getbyid(@PathVariable int id) {
		return ps.getproduitbyid(id);
	}
	
	@GetMapping
	public List<Produit> getallproduit(){
		return ps.getallproduit() ;
	}
	
	@PostMapping
	public int createproduit (@RequestBody Produit p) {
		return ps.addproduit(p);
	}
	
	@GetMapping(value = "/aff_p_to_c/{idp}/{idc}")
	public String get(@PathVariable int idp , @PathVariable int idc) {
		
		return ps.affecterproduit_to_commande(idp, idc);
	}

}
