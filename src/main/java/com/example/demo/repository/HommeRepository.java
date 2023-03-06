package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Homme;

public interface HommeRepository extends JpaRepository<Homme, Long> {

}
