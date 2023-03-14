package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Audit;
import com.example.demo.repository.AuditRepository;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional
    public Audit saveAudit(Audit audit) {
        return auditRepository.save(audit);
    }

    @Transactional(readOnly = true)
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    
}
