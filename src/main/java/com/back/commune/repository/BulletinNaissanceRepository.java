package com.back.commune.repository;

import com.back.commune.DTO.resulSet.CountByUser;
import com.back.commune.model.BulletinNaissance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BulletinNaissanceRepository extends JpaRepository<BulletinNaissance, Long>{

    Page<BulletinNaissance> findAll(Pageable pageable);
    BulletinNaissance findByIdPremierCopie(String idPremierCopie);

    @Query(value = "SELECT new com.back.commune.DTO.resulSet.CountByUser( b.createdBy, count(b.idBulletinNaissance)) FROM BulletinNaissance b group by b.createdBy")
    List<CountByUser> countByUser();
}
