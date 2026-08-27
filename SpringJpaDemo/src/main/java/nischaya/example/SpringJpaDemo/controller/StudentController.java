package nischaya.example.SpringJpaDemo.controller;

import nischaya.example.SpringJpaDemo.model.Student;
import nischaya.example.SpringJpaDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Student Created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long id){
        Optional<Student> student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }
}
