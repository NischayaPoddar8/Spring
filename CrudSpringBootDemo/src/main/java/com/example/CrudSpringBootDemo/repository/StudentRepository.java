package com.example.CrudSpringBootDemo.repository;

import com.example.CrudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
