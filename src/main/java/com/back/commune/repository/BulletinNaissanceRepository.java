package com.back.commune.repository;

import com.back.commune.model.BulletinNaissance;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulletinNaissanceRepository extends JpaRepository<BulletinNaissance, Long>{

 Page<BulletinNaissance> findAll(Pageable pageable);
 BulletinNaissance findByIdPremierCopie(String idPremierCopie);

}
