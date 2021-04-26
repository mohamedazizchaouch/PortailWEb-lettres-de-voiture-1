package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Facture;

public interface Facturedao extends JpaRepository<Facture, Integer> {

}
