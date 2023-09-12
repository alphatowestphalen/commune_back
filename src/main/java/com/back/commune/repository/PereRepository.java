package com.back.commune.repository;

import com.back.commune.model.Pere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PereRepository extends JpaRepository<Pere, Long> {

}
