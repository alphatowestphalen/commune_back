package com.back.commune.repository;



import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.Reconnaissance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReconnaissanceRepository extends JpaRepository<Reconnaissance, Long> {


    @Query("select r from Reconnaissance r left join PremierCopie p on r.premierecopie.idPremierCopie = p.idPremierCopie order by r.createdDate desc ")
    Page<Reconnaissance> findAll(Pageable pageable);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( r.createdBy, count(r.idReconnaissance)) FROM Reconnaissance r group by r.createdBy")
    List<CountByUser> countByUser();

    @Query("select count(p.idReconnaissance) from Reconnaissance  p WHERE  day(p.createdDate) = day(:jour) ")
    Long countByDays(@Param("jour") Date date);

    @Query("select count(p.idReconnaissance) from Reconnaissance  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    Long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idReconnaissance) from Reconnaissance  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    Long countByMonth(@Param("mois") String month, @Param("anne") String year);

    @Query("select count(p.idReconnaissance) from Reconnaissance  p " +
        "WHERE  year (p.createdDate) = :anne ")
    Long countByYear(@Param("anne") String year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idReconnaissance)) " +
        "FROM Reconnaissance p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idReconnaissance)) " +
        "FROM Reconnaissance p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idReconnaissance)) " +
        "FROM Reconnaissance p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") String month, @Param("anne") String year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idReconnaissance)) " +
        "FROM Reconnaissance p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") String date);
}
