package com.back.commune.repository;

import com.back.commune.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long>{

}
