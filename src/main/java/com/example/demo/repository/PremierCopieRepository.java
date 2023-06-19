package com.example.demo.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.PremierCopie;

@Repository
public interface PremierCopieRepository extends JpaRepository<PremierCopie, String> {
	
	PremierCopie findByIdPremierCopie(String IdPremierCopie);
	
	@Query(value = "SELECT * FROM premier_copie p ORDER BY p.created_date DESC LIMIT 1 ", nativeQuery = true)
	PremierCopie chercherPremierCopie(); 
	
	
	/*
	@Query(value = "SELECT p.numero FROM premier_copie p ORDER BY p.created_date DESC LIMIT 1 ", nativeQuery = true)
	long chercherNumeroCopie(); 
	@Query(value = "SELECT p.annee_actuelle FROM premier_copie p ORDER BY p.created_date DESC LIMIT 1 ", nativeQuery = true)
	int chercherAnneeCopie(); 
	*/
	
	
	Page<PremierCopie> findAll(Pageable pageable);
	Page<PremierCopie> findBydatePremierCopie(String datePremierCopie, Pageable pageable);
	Page<PremierCopie> findByIdPremierCopieStartsWith(String idPremierCopie , Pageable pageable );
	
	//@Query(value = "SELECT * FROM premier_copie LEFT JOIN enfant ON premier_copie.id_enfant = enfant.id_enfant WHERE enfant.nom_enfant LIKE %:NomEnfant% OR enfant.prenoms_enfant %:PrenomsEnfant% ", nativeQuery = true)
	
	Page<PremierCopie> findByEnfantNomEnfantStartsWithOrEnfantPrenomsEnfantStartsWith(String NomEnfant , String PrenomsEnfant, Pageable pageable );
	PremierCopie findTopByOrderByIdPremierCopieDesc();
	
	@Query(value = "SELECT count(p.id_premier_copie) FROM premier_copie p", nativeQuery = true)
	long countByIdPC();
	
	@Modifying
    @Query(value ="UPDATE premier_copie SET deleted = false WHERE id_premier_copie = :idPremierCopie", nativeQuery = true)
    void restorePremierCopie(@PathVariable("idPremierCopie") String idPremierCopie);
	
	
    @Query(value ="UPDATE premier_copie SET deleted = true WHERE id_premier_copie = :idPremierCopie", nativeQuery = true)
    void deletePremierCopie(@PathVariable("idPremierCopie") String idPremierCopie);
	
	
}
