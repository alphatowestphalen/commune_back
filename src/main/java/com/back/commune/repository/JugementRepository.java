package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.PremierCopie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.commune.model.Jugement;

import java.util.Date;
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

    @Query("select count(p.idJugement) from Jugement  p WHERE  day(p.createdDate) = day(:jour) ")
    long countByDays(@Param("jour") Date date);

    @Query("select count(p.idJugement) from Jugement  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idJugement) from Jugement  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    long countByMonth(@Param("mois") String month, @Param("anne") String year);

    @Query("select count(p.idJugement) from Jugement  p " +
        "WHERE  year (p.createdDate) = :anne ")
    long countByYear(@Param("anne") String year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idJugement)) " +
        "FROM Jugement p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idJugement)) " +
        "FROM Jugement p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idJugement)) " +
        "FROM Jugement p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") String month, @Param("anne") String year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idJugement)) " +
        "FROM Jugement p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") String date);
}
