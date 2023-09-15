package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.PremierCopie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.commune.model.Jugement;

import java.util.List;


@Repository
public interface JugementRepository extends JpaRepository<Jugement, Long> {
	Page<Jugement> findAll(Pageable pageable);

	@Query(value = "SELECT count(j.id_jugement) FROM jugement j", nativeQuery = true)
	long countByIdJugement();

    @Query("SELECT p from PremierCopie p where p.idPremierCopie not in (select j.premierCopie.idPremierCopie from Jugement j)")
    Page<PremierCopie> getAllPremierCopieNotHaveJugement(Pageable pageable);
    @Query("SELECT p from PremierCopie p where p.idPremierCopie in (select j.premierCopie.idPremierCopie from Jugement j)")
    Page<PremierCopie> getAllPremierCopieHaveJugement(Pageable pageable);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( j.createdBy, count(j.idJugement)) FROM Jugement j group by j.createdBy")
    List<CountByUser> countByUser();
}
