package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reconnaissance;
@Repository
public interface ReconnaissanceRepository extends JpaRepository<Reconnaissance, Long> {

	
}
