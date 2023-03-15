package com.example.demo.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PremierCopie;
import com.example.demo.model.Reconnaissance;

@Repository
public interface ReconnaissanceRepository extends JpaRepository<Reconnaissance, Long> {
	Page<Reconnaissance> findAll(Pageable pageable);
	
	@Query(value = "SELECT count(r.id_reconnaissance) FROM reconnaissance r", nativeQuery = true)
	long countByIdReconnaissance();
}
