package nischaya.example.JpaRelationshipdemo2.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nischaya.example.JpaRelationshipdemo2.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Department save(Department department){
        entityManager.persist(department);
        return department;
    }

    public Department getDepartment(Long id){
        return entityManager.find(Department.class,id);
    }

}
