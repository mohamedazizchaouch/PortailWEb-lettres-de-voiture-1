package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Commentaire_commande;

public interface CommentaireComDao extends JpaRepository<Commentaire_commande, Integer>{

}
