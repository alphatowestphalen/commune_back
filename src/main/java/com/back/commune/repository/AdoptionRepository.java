package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.commune.model.Adoption;

import java.util.Date;
import java.util.List;


@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

	Page<Adoption> findAll(Pageable pageable);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( a.createdBy, count(a.idAdoption)) FROM Adoption a group by a.createdBy")
    List<CountByUser> countByUser();

    @Query("select count(p.idAdoption) from Adoption  p WHERE  day(p.createdDate) = day(:jour) ")
    long countByDays(@Param("jour") Date date);

    @Query("select count(p.idAdoption) from Adoption  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idAdoption) from Adoption  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    long countByMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query("select count(p.idAdoption) from Adoption  p " +
        "WHERE  year (p.createdDate) = :anne ")
    long countByYear(@Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idAdoption)) " +
        "FROM Adoption p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idAdoption)) " +
        "FROM Adoption p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idAdoption)) " +
        "FROM Adoption p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idAdoption)) " +
        "FROM Adoption p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") Integer date);

    @Query("SELECT a FROM Adoption a WHERE cast(a.idAdoption as string ) like :query% or " +
        "lower(a.premierecopie.enfant.nomEnfant) like lower(concat(:query,'%')) or " +
        "lower(a.premierecopie.enfant.prenomsEnfant) like lower(concat(:query,'%')) " +
        "order by a.createdDate desc ")
    Page<Adoption> findSearchAll(@Param("query") String query, Pageable pageable);
}
