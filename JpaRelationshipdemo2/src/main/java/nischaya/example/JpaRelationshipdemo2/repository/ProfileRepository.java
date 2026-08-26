package nischaya.example.JpaRelationshipdemo2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nischaya.example.JpaRelationshipdemo2.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Profile profile){
        entityManager.persist(profile);
    }
}
