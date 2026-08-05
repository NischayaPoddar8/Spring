package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // Postman--->Controller--->Service--->Repository--->Database
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student studentReq){
        // Function to perform business logic and will pass to repository
        System.out.println("Inside Student Service");
        Student studentResponse = studentRepository.saveStudent(studentReq);
        System.out.println("Exitting Student Service");
        return studentResponse;
    }
}
