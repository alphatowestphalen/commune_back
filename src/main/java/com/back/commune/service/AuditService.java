package com.back.commune.service;

import java.util.List;

import com.back.commune.model.Audit;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import com.back.commune.repository.AuditRepository;

@Service
public class AuditService {

    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional
    public void saveAudit(Audit audit) {
        //auditRepository.save(audit);
    }

    @Transactional(readOnly = true)
    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }


}
