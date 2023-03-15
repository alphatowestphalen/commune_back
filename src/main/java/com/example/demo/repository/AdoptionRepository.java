package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;


@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

	Page<Adoption> findAll(Pageable pageable);
	
	@Query(value = "SELECT count(a.id_adoption) FROM adoption a", nativeQuery = true)
	long countByIdAdoption();
}
