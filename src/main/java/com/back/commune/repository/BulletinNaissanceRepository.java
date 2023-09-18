package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.BulletinNaissance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BulletinNaissanceRepository extends JpaRepository<BulletinNaissance, Long>{

    Page<BulletinNaissance> findAll(Pageable pageable);
    BulletinNaissance findByIdPremierCopie(String idPremierCopie);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( b.createdBy, count(b.idBulletinNaissance)) FROM BulletinNaissance b group by b.createdBy")
    List<CountByUser> countByUser();

    @Query("select count(p.idBulletinNaissance) from BulletinNaissance  p WHERE  day(p.createdDate) = day(:jour) ")
    long countByDays(@Param("jour") Date date);

    @Query("select count(p.idBulletinNaissance) from BulletinNaissance  p WHERE  day(p.createdDate) between day(:jour1) and day(:jour2) ")
    long countByDays(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query("select count(p.idBulletinNaissance) from BulletinNaissance  p " +
        "WHERE  month (p.createdDate) = :mois and year (p.createdDate) = :anne")
    long countByMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query("select count(p.idBulletinNaissance) from BulletinNaissance  p " +
        "WHERE  year (p.createdDate) = :anne ")
    long countByYear(@Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idBulletinNaissance)) " +
        "FROM BulletinNaissance p WHERE  DAY(p.createdDate) = day(:jour) group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour") Date date);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idBulletinNaissance)) " +
        "FROM BulletinNaissance p WHERE  DAY(p.createdDate) between day(:jour1) and day(:jour2)  group by p.createdBy")
    List<CountByUser> countByUserDay(@Param("jour1") Date date1, @Param("jour2") Date date2);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idBulletinNaissance)) " +
        "FROM BulletinNaissance p WHERE  month (p.createdDate) = :mois and year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserMonth(@Param("mois") Integer month, @Param("anne") Integer year);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( p.createdBy, count(p.idBulletinNaissance)) " +
        "FROM BulletinNaissance p WHERE  year(p.createdDate) = :anne group by p.createdBy")
    List<CountByUser> countByUserYear(@Param("anne") Integer date);
}
