package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Jugement;


@Repository
public interface JugementRepository extends JpaRepository<Jugement, Long> {
	Page<Jugement> findAll(Pageable pageable);
}
