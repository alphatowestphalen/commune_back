package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ActeDeces;

public interface ActeDecesRepository extends JpaRepository<ActeDeces, Long>{

	ActeDeces findByIdActeDeces(String idActeDeces);
	
	@Query(value = "SELECT * FROM acte_deces a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeDeces chercherActeDeces(); 
}
