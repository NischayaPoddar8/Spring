package nischaya.example.SpringAopDemo.controller;

import nischaya.example.SpringAopDemo.dto.Student;
import nischaya.example.SpringAopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student>createStudent(@RequestBody Student student){
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String>getStudent(String s){
        s = "All students data";
        studentService.getStudent(s);
        return ResponseEntity.ok(s);
    }

}
