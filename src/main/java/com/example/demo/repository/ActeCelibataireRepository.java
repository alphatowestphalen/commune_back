package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ActeCelibataire;


public interface ActeCelibataireRepository extends JpaRepository<ActeCelibataire, String> {

	@Query(value = "SELECT * FROM acte_celibataire a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeCelibataire chercherActeCelibataire(); 
}
