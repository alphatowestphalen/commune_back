package com.back.commune.repository;



import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.Reconnaissance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReconnaissanceRepository extends JpaRepository<Reconnaissance, Long> {


    @Query("select r from Reconnaissance r left join PremierCopie p on r.premierecopie.idPremierCopie = p.idPremierCopie")
    Page<Reconnaissance> findAll(Pageable pageable);
	@Query(value = "SELECT count(r.id_reconnaissance) FROM reconnaissance r", nativeQuery = true)
	long countByIdReconnaissance();

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( r.createdBy, count(r.idReconnaissance)) FROM Reconnaissance r group by r.createdBy")
    List<CountByUser> countByUser();
}
