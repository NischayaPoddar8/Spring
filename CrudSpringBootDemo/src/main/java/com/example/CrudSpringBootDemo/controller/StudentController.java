package com.example.CrudSpringBootDemo.controller;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Converts Java objects into JSON or XML and the class gets marked as controller
@RequestMapping("/api/students") // entertain req of this form
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 1. Create Student  POST--->/api/students
    @PostMapping// ("/create") for /api/students/create
    public String createStudent(@RequestBody  Student student){ // Converts java objects to json
//        System.out.println(student.getName());
//        System.out.println(student.getEmailId());
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.saveStudent(student);
        System.out.println("Exitting Student Controller");
        return "Student created";
    }

    // 2. Read Student  GET--->/api/students To read all

    // 3. Update Student  PUT--->/api/students/{id}

    //4. Delete Student  DELETE---->/api/students/{id}

}
