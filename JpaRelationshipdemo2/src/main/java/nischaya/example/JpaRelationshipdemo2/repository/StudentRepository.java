package nischaya.example.JpaRelationshipdemo2.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nischaya.example.JpaRelationshipdemo2.model.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public Student fetchById(Long id){
        return entityManager.find(Student.class,id);
    }

    // Eagerly fetches department and profile as we wish to get list of all students
    @EntityGraph(attributePaths = "{department,profile}")
    public List<Student>findAll(){
        
    }

}
