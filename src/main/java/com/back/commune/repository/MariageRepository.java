package com.back.commune.repository;


import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.mariage.Mariage;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MariageRepository extends JpaRepository<Mariage, Long> {
	Page<Mariage> findAll( Pageable pageable);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( m.createdBy, count(m.idMariage)) FROM Mariage m group by m.createdBy")
    List<CountByUser> countByUser();

    @Query("select count(p.idMariage) from Mariage  p WHERE  day(p.createdDate) = day(:jour) ")
    long countByDays(@Param("jour") Date date);

    @Query("select count(p.idMariage) from Mariage  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idMariage) from Mariage  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    long countByMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query("select count(p.idMariage) from Mariage  p " +
        "WHERE  year (p.createdDate) = :anne ")
    long countByYear(@Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idMariage)) " +
        "FROM Mariage p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idMariage)) " +
        "FROM Mariage p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idMariage)) " +
        "FROM Mariage p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idMariage)) " +
        "FROM Mariage p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") Integer date);

    @Query("SELECT m FROM Mariage m \n" +
        "LEFT JOIN MariageAllInterne mii ON mii.idMariage = m.idMariage\n" +
        "LEFT JOIN MariageAllExterne mee ON mee.idMariage = m.idMariage\n" +
        "LEFT JOIN MariageMixteFemme mei ON mei.idMariage = m.idMariage\n" +
        "LEFT JOIN MariageMixteHomme mie ON mie.idMariage = m.idMariage " +
        "WHERE \n" +
        "  ( \n" +
        "    TYPE(m) = MariageAllInterne AND (\n" +
        "      lower(mii.femme.enfant.nomEnfant) like lower(concat(:query,'%')) \n" +
        "      OR lower(mii.femme.enfant.prenomsEnfant) like lower(concat(:query,'%')) \n" +
        "      OR lower(mii.homme.enfant.nomEnfant) like lower(concat(:query,'%')) \n" +
        "      OR lower(mii.homme.enfant.prenomsEnfant) like lower(concat(:query,'%'))\n" +
        "    )\n" +
        "  )\n" +
        "  OR\n" +
        "  (\n" +
        "    TYPE(m) = MariageAllExterne AND (\n" +
        "      lower(mee.femme.nomFemme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mee.femme.prenomsFemme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mee.homme.nomHomme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mee.homme.prenomsHomme) like lower(concat(:query,'%'))\n" +
        "    )\n" +
        "  )\n" +
        "  OR\n" +
        "  (\n" +
        "    TYPE(m) = MariageMixteFemme AND (\n" +
        "      lower(mei.homme.nomHomme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mei.homme.prenomsHomme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mei.femme.enfant.nomEnfant) like lower(concat(:query,'%')) \n" +
        "      OR lower(mei.femme.enfant.prenomsEnfant) like lower(concat(:query,'%'))\n" +
        "    )\n" +
        "  )\n" +
        "  OR\n" +
        "  (\n" +
        "    TYPE(m) = MariageMixteHomme AND (\n" +
        "      lower(mie.femme.nomFemme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mie.femme.prenomsFemme) like lower(concat(:query,'%')) \n" +
        "      OR lower(mie.homme.enfant.nomEnfant) like lower(concat(:query,'%')) \n" +
        "      OR lower(mie.homme.enfant.prenomsEnfant) like lower(concat(:query,'%'))\n" +
        "    )\n" +
        "  )" )
    Page<Mariage> findSearchAll(@Param("query") String query, Pageable pageable);

}
