package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Maire;
@Repository
public interface MaireRepository extends JpaRepository<Maire, Long> {

}
