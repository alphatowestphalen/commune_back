package com.back.commune.repository;

import com.back.commune.model.Mere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MereRepository extends JpaRepository<Mere, Long> {

}
