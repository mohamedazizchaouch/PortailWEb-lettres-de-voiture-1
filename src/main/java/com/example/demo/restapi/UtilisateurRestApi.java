package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Client;
import com.example.demo.model.User;
import com.example.demo.model.Utilisateur;
import com.example.demo.service.Utilisateur_service;

@RestController
@RequestMapping(value = "/api/utilisateur")
public class UtilisateurRestApi {
	
	@Autowired
	private Utilisateur_service userservice ;
	
	
	@GetMapping

	public List<Utilisateur> createCandidat() {
		return userservice.getalluserss();
				}
	
	@GetMapping(value = "/{mdp}/{login}")
	public User login (@PathVariable(value = "mdp") String mdp ,@PathVariable(value = "login") String login) {
		
		System.out.println("11111111"+mdp);
		System.out.println("11111111"+login);
		
		return userservice.login(mdp, login);
	}

}
