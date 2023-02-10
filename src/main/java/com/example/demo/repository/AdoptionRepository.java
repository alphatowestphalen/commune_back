package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
	
	@Query(value = " SELECT * FROM premier_copie_adoptions pa, premier_copie p, adoption a WHERE pa.id_premier = p.id_premier_copie AND pa.id_ado = a.id_adoption AND a.id_adoption = 'id'", nativeQuery = true)
	List<PremierCopie> getAdoptionById(@PathVariable(value = "id") Long id);
/*
	Adoption findPremierCopiesByIdAdoption(Long id);
	*/
}
