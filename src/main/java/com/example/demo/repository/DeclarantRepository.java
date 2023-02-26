package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Declarant;
@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {

}
