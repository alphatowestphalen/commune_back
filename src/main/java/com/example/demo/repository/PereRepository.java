package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pere;
@Repository
public interface PereRepository extends JpaRepository<Pere, Long> {

}
