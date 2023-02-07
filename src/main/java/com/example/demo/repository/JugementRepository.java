package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Jugement;

public interface JugementRepository extends JpaRepository<Jugement, Long> {

}
