package nischaya.example.JpaRelationshipDemo.controller;

import nischaya.example.JpaRelationshipDemo.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public  StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
}
