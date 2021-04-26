package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Produit;

public interface ProduitDao extends JpaRepository<Produit, Integer> {

}
