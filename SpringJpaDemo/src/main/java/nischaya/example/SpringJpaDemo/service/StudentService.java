package nischaya.example.SpringJpaDemo.service;

import nischaya.example.SpringJpaDemo.model.Student;
import nischaya.example.SpringJpaDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Optional<Student> getStudent(Long id){
        Optional<Student> student =  studentRepository.findById(id);
        return student;
    }
}
