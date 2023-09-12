package com.back.commune.repository;

import com.back.commune.model.Maire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaireRepository extends JpaRepository<Maire, Long> {

}
