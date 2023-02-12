package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Adoption;
import com.example.demo.model.PremierCopie;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {

}
