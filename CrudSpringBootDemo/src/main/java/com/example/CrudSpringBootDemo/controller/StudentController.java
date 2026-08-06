package com.example.CrudSpringBootDemo.controller;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import com.example.CrudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Converts Java objects into JSON or XML and the class gets marked as controller
@RequestMapping("/api/students") // entertain req of this form
public class StudentController {

    private final StudentRepository studentRepository;
    private StudentService studentService;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    // 1. Create Student  POST--->/api/students
    @PostMapping// ("/create") for /api/students/create
    public ResponseEntity<Student> createStudent(@RequestBody  Student student){ // Converts java objects to JSON

        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent); // To send 201 code instead of 200 which is ok
    }

    // 2. Read One Student  GET--->/api/students/{id} To read one
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);
        if (studentResp!=null) return ResponseEntity.ok(studentResp);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // GetAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student>studentResp = studentService.getAllStudents();
        if (studentResp!=null) return ResponseEntity.ok(studentResp);
        return ResponseEntity.notFound().build();
    }

    // 3. Update Student  PUT--->/api/students/{id}
    @PutMapping ("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentReq){ // student body is required to update
        Student studentResp = studentService.updateStudent(id,studentReq);
        if (studentResp!=null) return ResponseEntity.ok(studentResp);
        return ResponseEntity.notFound().build();
    }


    //4. Delete Student  DELETE---->/api/students/{id}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){ // student body is required to update
        Boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) return ResponseEntity.ok("Student record deleted");
        return ResponseEntity.notFound().build();
    }
}
