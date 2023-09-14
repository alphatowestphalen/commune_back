package com.back.commune.repository;



import com.back.commune.model.Reconnaissance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReconnaissanceRepository extends JpaRepository<Reconnaissance, Long> {


    @Query("select r from Reconnaissance r left join PremierCopie p on r.premierecopie.idPremierCopie = p.idPremierCopie")
    Page<Reconnaissance> findAll(Pageable pageable);
	@Query(value = "SELECT count(r.id_reconnaissance) FROM reconnaissance r", nativeQuery = true)
	long countByIdReconnaissance();
}