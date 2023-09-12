package com.back.commune.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.commune.model.Adoption;


@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

	Page<Adoption> findAll(Pageable pageable);

	@Query(value = "SELECT count(a.id_adoption) FROM adoption a", nativeQuery = true)
	long countByIdAdoption();
}
