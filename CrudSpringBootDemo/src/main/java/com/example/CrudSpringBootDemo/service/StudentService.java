package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq); // save is used to save record
        return studentResp;
    }

    // Student == id and deleted == false
    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id); // If such record does not exist to stay safe we use optional student which can be null as well
        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null; // find by id and deleted is false
    }

    // Find all and deleted is false also start name from findBy ---> Naming convention for spring to define the method
    public List<Student>getAllStudents(){
        List<Student>studentList = studentRepository.findByDeletedIsFalse();
        return studentList; // find those which are not deleted
    }


    public Student updateStudent(Long id,Student studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id); // If such record does not exist we cant update then
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setEmailId(studentReq.getEmailId());
        studentToSave.setSubject(studentReq.getSubject());

        studentToSave.setDeleted(false); // so that nobody can update deleted
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

    public Boolean softDeleteStudent(Long id){
        // 1. Get details even if the student exists
        Optional<Student>existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if (existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        // 2. Mark as deleted
        studentToSave.setDeleted(true);
        // 3. Save
        studentRepository.save(studentToSave);
        return true; // Soft deleted
    }
}
