package com.back.commune.repository;

import com.back.commune.model.demande.DemandeEtatCivile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface DemandeEtatCivileRepository extends JpaRepository<DemandeEtatCivile, Long> {

    @Query("SELECT d FROM DemandeEtatCivile d WHERE d.maire = null")
    Page<DemandeEtatCivile> findAllNotSigned(Pageable pageable);

    @Modifying
    @Query("update DemandeEtatCivile d set d.maire = :idMaire where d.idDemande = :idDemande")
    DemandeEtatCivile setSigned(@Param("idDemande") String idDemande, @Param("idMaire") String idMaire);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE d.maire = null and d.createdAt = :date")
    Page<DemandeEtatCivile> findAllNotSigned(@Param("date") Date date,Pageable pageable);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE  d.createdAt = :date")
    Page<DemandeEtatCivile> findAllByDate(@Param("date") Date date, Pageable pageable);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE  YEAR (d.createdAt) = year (:date) and MONTH(d.createdAt) = MONTH(:date)")
    Page<DemandeEtatCivile> findAllByMonth(@Param("date") Date date, Pageable pageable);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE  YEAR (d.createdAt) = :_year and MONTH(d.createdAt) = :_month ")
    Page<DemandeEtatCivile> findAllByMonth(@Param("_month") String month, @Param("_year") String year , Pageable pageable);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE  YEAR(d.createdAt) = YEAR(:date)")
    Page<DemandeEtatCivile> findAllByYear(@Param("date") Date date, Pageable pageable);

    @Query("SELECT d FROM DemandeEtatCivile d WHERE  YEAR(d.createdAt) =:date")
    Page<DemandeEtatCivile> findAllByYear(@Param("date") String date, Pageable pageable);
}
