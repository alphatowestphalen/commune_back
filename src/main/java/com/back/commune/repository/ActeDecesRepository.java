package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.deces.ActeDeces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ActeDecesRepository extends JpaRepository<ActeDeces, Long>{

	@Query(value = "SELECT * FROM acte_deces a ORDER BY a.created_date DESC LIMIT 1 ", nativeQuery = true)
	ActeDeces chercherActeDeces();

	@Query(value = "SELECT count(a.id_acte_deces) FROM acte_deces a", nativeQuery = true)
	long countByIdDeces();

    @Query("SELECT new com.back.commune.DTO.resulSet.CountByUser(a.createdBy, count(a.idActeDeces)) FROM ActeDeces a GROUP BY a.createdBy")
    List<CountByUser> countByUser();

    @Query("select count(p.idActeDeces) from ActeDeces  p WHERE  day(p.createdDate) = day(:jour) ")
    long countByDays(@Param("jour") Date date);

    @Query("select count(p.idActeDeces) from ActeDeces  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idActeDeces) from ActeDeces  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    long countByMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query("select count(p.idActeDeces) from ActeDeces  p " +
        "WHERE  year (p.createdDate) = :anne ")
    long countByYear(@Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeDeces)) " +
        "FROM ActeDeces p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeDeces)) " +
        "FROM ActeDeces p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeDeces)) " +
        "FROM ActeDeces p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idActeDeces)) " +
        "FROM ActeDeces p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") Integer date);

    @Query("SELECT d FROM ActeDeces d WHERE cast(d.idActeDeces as string ) like :query% " +
        "or lower(d.defunt.nomDefunt) like lower( concat(:query,'%')) order by d.defunt.dateDeces desc ")
    Page<ActeDeces> findAllSearch(@Param("query") String query, Pageable pageable);
}
