package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Imprimeur;

public interface ImprimeurDao extends JpaRepository<Imprimeur, Integer> {

}
