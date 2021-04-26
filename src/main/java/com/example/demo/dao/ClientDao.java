package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Cl;
import com.example.demo.model.Client;

public interface ClientDao extends JpaRepository<Client, Integer> {
	
	@Query("select   c.code_client , c.raison_social from Client c ")
	public List<Client>gettt();

	

}
