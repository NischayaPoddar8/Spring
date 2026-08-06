package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service // Postman--->Controller--->Service--->Repository--->Database
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentResp = studentRepository.save(studentReq); // save is used to save record
        return studentReq;
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id); // If such record does not exist to stay safe we use optional student which can be null as well
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student>getAllStudents(){
        List<Student>studentList = studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent = studentRepository.findById(id); // If such record does not exist we cant update then
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmailId(studentReq.getEmailId());
        studentToSave.setSubject(studentReq.getSubject());

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id); // First check if there is record to delete
        if (!isStudent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
