package com.example.demo.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Fichier_BAT;
import com.example.demo.service.Fichier_bat_service;

@RestController
@RequestMapping(value = "/api/fichier")
public class Fichier_batRestApi {

	
	@Autowired
	private Fichier_bat_service fs ;
	
	
	//depot fichier bat 
	@PostMapping(value = "/{idimp}/{idcom}")
	public int createfichierbat(@RequestBody Fichier_BAT f,@PathVariable int idimp, @PathVariable int idcom) {
		return fs.createficherbat(f,idimp,idcom);
	}
}
