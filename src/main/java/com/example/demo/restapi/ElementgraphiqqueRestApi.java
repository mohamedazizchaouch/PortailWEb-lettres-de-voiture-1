package com.example.demo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Element_ghraphique;
import com.example.demo.service.Elementghraphique_service;

@RestController
@RequestMapping(value = "/api/element")
public class ElementgraphiqqueRestApi {
	
	@Autowired
	private Elementghraphique_service  es;
	
	
	@PostMapping(value = "/{idc}")
	public int create (@RequestBody Element_ghraphique e, @PathVariable int idc) {
		return es.add(e, idc);
	}
	
	@GetMapping
	public List<Element_ghraphique>getall(){
		return es.getall();
	}

}
