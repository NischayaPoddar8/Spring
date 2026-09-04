package nischaya.example6.JpaRelationshipsTransactionalProject.service;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.AuditLog;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.AuditLogRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditLogRepo auditLogRepo;

    public AuditService(AuditLogRepo auditLogRepo) {
        this.auditLogRepo = auditLogRepo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW) // Always create a new persistence context
    public void log(String action, String details) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setDetails(details);
        log.setTimeStamp(LocalDateTime.now());

        auditLogRepo.save(log);
    }

}
