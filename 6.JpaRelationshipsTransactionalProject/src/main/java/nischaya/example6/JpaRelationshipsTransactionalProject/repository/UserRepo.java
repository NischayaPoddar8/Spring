package nischaya.example6.JpaRelationshipsTransactionalProject.repository;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    
}
