package nischaya.example.JpaRelationshipDemo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nischaya.example.JpaRelationshipDemo.model.Department;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Department department){
        entityManager.persist(department);
    }

    public Department getDepartment(Long id){
        return entityManager.find(Department.class,id);
    }


}
