package com.back.commune.repository;

import com.back.commune.model.Declarant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarantRepository extends JpaRepository<Declarant, Long> {

}
