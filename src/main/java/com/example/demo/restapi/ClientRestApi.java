package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientDao;
import com.example.demo.model.Cl;
import com.example.demo.model.Client;
import com.example.demo.model.Commande;
import com.example.demo.model.Sclient;
import com.example.demo.service.Client_service;

@RestController
@RequestMapping(value = "/api/client")
public class ClientRestApi {
	
	@Autowired
	private Client_service clientservice ;
	@Autowired
	private ClientDao cldao;
	
	
	
	@PostMapping
	public int createclient (@RequestBody Client c) {
		return clientservice.addClient(c);
		}
	
	@GetMapping
	public List<Client> getallclients(){
		return clientservice.getallClient();
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteclient(@PathVariable int id) {
		return clientservice.deleteClient(id);
	}
	
	//commande encours d'un client 
	@GetMapping(value = "/com_encours/{id}")
	public List<Commande>gettcommendeclient_encours(@PathVariable int id){
		return clientservice.getcommandeclient_encours(id);
	}
	
	//historique commande d'un client
	
	@GetMapping(value = "/historique/{id}")
	public List<Commande>gethistorique (@PathVariable int id ){
		return clientservice.getHistoriquecomm_client(id);
	}
	//accepter bat
	@GetMapping(value = "/accepter_bat/{idc}")
	public int accepterbat(@PathVariable int idc) {
		return clientservice.accepterbat(idc);
	}
	
	//refuser bat 
	@GetMapping(value = "/refuser_bat/{idc}")
	public int refuserbat (@PathVariable int idc) {
		return clientservice.refuserbat(idc);
	}
	
	@GetMapping(value = "/test")
	public List<Client>aaaa(){
		return cldao.gettt();
		
	}
	
	

}
