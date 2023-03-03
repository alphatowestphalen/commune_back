package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PieceJustificative;
@Repository
public interface PieceJustificativeRepository extends JpaRepository<PieceJustificative, Long> {

}
