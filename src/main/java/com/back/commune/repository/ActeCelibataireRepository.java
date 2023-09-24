package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.commune.model.celibataire.ActeCelibataire;

import java.util.List;


public interface ActeCelibataireRepository extends JpaRepository<ActeCelibataire, Long> {

	@Query(value = "SELECT * FROM acte_celibataire a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeCelibataire chercherActeCelibataire();

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( a.createdBy, count(a.idActeCelibataire)) FROM ActeCelibataire a group by a.createdBy")
    List<CountByUser> countByUser();
}
