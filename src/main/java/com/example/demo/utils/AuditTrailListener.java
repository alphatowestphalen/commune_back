package com.example.demo.utils;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Auditable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.model.Audit;
import com.example.demo.service.AuditService;

@Component
public class AuditTrailListener {

    @Autowired
    private AuditService auditService;
    

    @PrePersist
    public void beforePersist(Object object) {
        final Audit audit = createAudit(object, "CREATE");
        auditService.saveAudit(audit);

    }


    @PreUpdate
    private void beforeUpdate(Object object) { 
        final Audit audit = createAudit(object, "UPDATE");
        auditService.saveAudit(audit);
     }

    @PreRemove
    private void beforeRemove(Object object) { 
        final Audit audit = createAudit(object, "DELETE");
        auditService.saveAudit(audit);
     }





    private Audit createAudit(Object object, String type){

        final Audit audit = new Audit();

        audit.setEntity(object.getClass().getSimpleName());
        audit.setModifiedAt(LocalDateTime.now());
        audit.setModifiedBy(getCurrentUser());
        audit.setOperation(type);
        audit.setPayload(object.toString());

        return audit;
    }

    private String getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return null;
    }
    
}
