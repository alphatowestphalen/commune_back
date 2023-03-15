package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long>{

}
