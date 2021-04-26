package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cl;
import com.example.demo.model.Scarnet;
import com.example.demo.model.Sclient;
import com.example.demo.service.Statistique_service;
@RestController
@RequestMapping(value = "/api/stat")

public class StatistiqueRestApi {
	
	
	@Autowired
	private Statistique_service ss ;
	
	
	//stat_refproduit
		@GetMapping(value = "/stat_refproduit")
		public List<Cl>stat_refproduit(){
			return  ss.stat_refproduit();
		}
		
		//stat_nbrclient
		@GetMapping(value = "/stat_nbrclient")
		public List<Sclient> stat_nbrclient(){
			return ss.stat_nbrclient();
		}
		
		//stat_nbrcarnet
		@GetMapping(value = "/stat_nbrcarnet")
		public List<Scarnet>stat_nbrcarnet(){
			return ss.stat_nbrcarnet();
		}
		

}
