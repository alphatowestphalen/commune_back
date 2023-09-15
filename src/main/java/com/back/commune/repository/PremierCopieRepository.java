package com.back.commune.repository;


import java.util.List;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.Adoption;
import com.back.commune.model.Reconnaissance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.back.commune.model.PremierCopie;

@Repository
public interface PremierCopieRepository extends JpaRepository<PremierCopie, String> {

	PremierCopie findByIdPremierCopie(String IdPremierCopie);

	@Query(value = "SELECT * FROM premier_copie p ORDER BY p.created_date DESC LIMIT 1 ", nativeQuery = true)
	PremierCopie chercherPremierCopie();

    @Query(value = "SELECT p FROM PremierCopie p WHERE p.deleted = false ORDER BY p.createdDate DESC")
    List<PremierCopie> findAllPremierCopie();
	Page<PremierCopie> findAll(Pageable pageable);
	Page<PremierCopie> findBydatePremierCopie(String datePremierCopie, Pageable pageable);
	Page<PremierCopie> findByIdPremierCopieStartsWith(String idPremierCopie , Pageable pageable );
	Page<PremierCopie> findByEnfantNomEnfantStartsWithOrEnfantPrenomsEnfantStartsWith(String NomEnfant , String PrenomsEnfant, Pageable pageable );
	PremierCopie findTopByOrderByIdPremierCopieDesc();

	@Query(value = "SELECT count(p.id_premier_copie) FROM premier_copie p", nativeQuery = true)
	long countByIdPC();

    @Modifying
    @Query("UPDATE PremierCopie p SET p.deleted = true WHERE p.idPremierCopie = :idPremierCopie")
    void deletePremierCopie(@PathVariable("idPremierCopie") String idPremierCopie);

    @Query("SELECT r FROM Reconnaissance r where r.premierecopie.idPremierCopie = :idPremierCopie")
    List<Reconnaissance> findAllReconnaissances(@Param("idPremierCopie") String idPremierCopie);

    @Query("SELECT a FROM Adoption a where a.premierecopie.idPremierCopie = :idPremierCopie")
    List<Adoption> findAllAdoptions(@Param("idPremierCopie") String idPremierCopie);

    @Modifying
    @Query("UPDATE PremierCopie p SET p.deleted = false WHERE p.idPremierCopie = :idPremierCopie")
    void undoDeletePremierCopie(String idPremierCopie);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idPremierCopie)) FROM PremierCopie p WHERE p.deleted = false group by p.createdBy")
    List<CountByUser> countByUser();
    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idPremierCopie)) FROM PremierCopie p WHERE p.deleted = true group by p.createdBy")
    List<CountByUser> countDeletedByUser();
}
