package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.back.commune.model.celibataire.ActeCelibataire;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ActeCelibataireRepository extends JpaRepository<ActeCelibataire, Long> {

	@Query(value = "SELECT * FROM acte_celibataire a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeCelibataire chercherActeCelibataire();

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( a.createdBy, count(a.idActeCelibataire)) FROM ActeCelibataire a group by a.createdBy")
    List<CountByUser> countByUser();
    @Query("select count(p.idActeCelibataire) from ActeCelibataire  p WHERE  day(p.createdDate) = day(:jour) ")
    Long countByDays(@Param("jour") Date date);

    @Query("select count(p.idActeCelibataire) from ActeCelibataire  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    Long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idActeCelibataire) from ActeCelibataire  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    Long countByMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query("select count(p.idActeCelibataire) from ActeCelibataire  p " +
        "WHERE  year(p.createdDate) = :anne ")
    Long countByYear(@Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeCelibataire)) " +
        "FROM ActeCelibataire p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeCelibataire)) " +
        "FROM ActeCelibataire p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeCelibataire)) " +
        "FROM ActeCelibataire p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeCelibataire)) " +
        "FROM ActeCelibataire p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") Integer year);

    @Query("SELECT s FROM ActeCelibataire s WHERE CAST(s.idActeCelibataire as string ) like :query% " +
        "or  lower(concat(s.premierecopie.enfant.nomEnfant,' ',s.premierecopie.enfant.prenomsEnfant)) like lower(concat(:query,'%')) ")
    Page<ActeCelibataire> findSearchAll(@Param("query") String query, Pageable pageable);
}
