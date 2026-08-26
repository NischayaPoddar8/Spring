package nischaya.example.JpaRelationshipdemo2.controller;

import nischaya.example.JpaRelationshipdemo2.model.Student;
import nischaya.example.JpaRelationshipdemo2.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public  StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Student created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>getStudent(@PathVariable  Long id){
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

}
