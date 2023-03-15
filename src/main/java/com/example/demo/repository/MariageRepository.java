package com.example.demo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Mariage;

public interface MariageRepository extends JpaRepository<Mariage, Long> {
	
	@Query(value = "SELECT * FROM mariage m ORDER BY m.created_date DESC LIMIT 1 ", nativeQuery = true)
	Mariage chercherMariage();
	
	Mariage findByIdMariage(String idMariage);

	Page<Mariage> findAll( Pageable pageable);

}
