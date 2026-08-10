package com.example.CrudSpringBootDemo.controller;

import com.example.CrudSpringBootDemo.Dto.CreateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.CreateStudentResponseDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentResponseDto;
import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import com.example.CrudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
// Postman--->Controller--->Service--->Repository--->Database
public class StudentController {

    private StudentRepository studentRepository;
    private StudentService studentService;

    public StudentController(StudentService studentService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid  @RequestBody CreateStudentRequestDto createStudentRequestDto){ // Converts java objects to JSON

        CreateStudentResponseDto createdStudent = studentService.createStudent(createStudentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent); // To send 201 code instead of 200 which is ok
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentResp = studentService.getStudent(id);
        if (studentResp!=null) return ResponseEntity.ok(studentResp);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // GetAll
    @GetMapping("/getAll")
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents(){
        List<CreateStudentResponseDto>studentResp = studentService.getAllStudents();
        if (studentResp!=null) return ResponseEntity.ok(studentResp);
        return ResponseEntity.notFound().build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@PathVariable Long id, @RequestBody UpdateStudentRequestDto studentReq){ // student body is required to update
        UpdateStudentResponseDto studentResponse = studentService.updateStudent(id,studentReq);
        if (studentResponse!=null) return ResponseEntity.ok(studentResponse);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){ // student body is required to update
        Boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) return ResponseEntity.ok("Student record deleted");
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<String>softDeleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.softDeleteStudent(id);
        if (isDeleted) return ResponseEntity.ok("Student record deleted softly");
        return ResponseEntity.notFound().build();
    }
}
