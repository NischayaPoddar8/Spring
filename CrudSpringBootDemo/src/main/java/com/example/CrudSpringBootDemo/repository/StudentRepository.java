package com.example.CrudSpringBootDemo.repository;

import com.example.CrudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student studentReq){
        // Save to database
        System.out.println("Inside Student Repository");
        System.out.println("Exitting Student Repository");
        return null;
    }

}
