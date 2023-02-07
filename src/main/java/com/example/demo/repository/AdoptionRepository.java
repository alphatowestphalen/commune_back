package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

}
