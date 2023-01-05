package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Declarant;

public interface DeclarantRepository extends JpaRepository<Declarant, Long> {

}
