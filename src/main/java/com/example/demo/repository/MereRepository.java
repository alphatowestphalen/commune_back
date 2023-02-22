package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Mere;
@Repository
public interface MereRepository extends JpaRepository<Mere, Long> {

}
