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

    @PostMapping("/{dept_id}") // For existing department
    public ResponseEntity<String> createStudent(@RequestBody Student student, @PathVariable Long dept_id){
        studentService.createStudent(student,dept_id);
        return ResponseEntity.ok("Student created");
    }

    @PostMapping
    public ResponseEntity<String>createStudent(@RequestBody Student student,@RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("Student created");
    }

}
