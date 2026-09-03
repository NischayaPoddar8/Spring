package nischaya.example6.JpaRelationshipsTransactionalProject.repository;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepo extends JpaRepository<AuditLog,Long> {
}
