package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.commune.model.Adoption;

import java.util.List;


@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

	Page<Adoption> findAll(Pageable pageable);

	@Query(value = "SELECT count(a.id_adoption) FROM adoption a", nativeQuery = true)
	long countByIdAdoption();

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( a.createdBy, count(a.idAdoption)) FROM Adoption a group by a.createdBy")
    List<CountByUser> countByUser();
}
