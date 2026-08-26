package nischaya.example.JpaRelationshipdemo2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nischaya.example.JpaRelationshipdemo2.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

}
