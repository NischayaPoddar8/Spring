package nischaya.example.SpringJpaDemo.repository;

import nischaya.example.SpringJpaDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long>{

    @Query(value = """ 
        select * from student 
        where emailId = :xyz        
    """ , nativeQuery = true) // Second emailId is same as Param as first one is the name of field in student
    Optional<Student> findByEmailId(@Param("xyz") String emailId); // Will find by emailId


}
