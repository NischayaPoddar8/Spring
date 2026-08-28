package nischaya.example.SpringJpaDemo.service;

import nischaya.example.SpringJpaDemo.model.Student;
import nischaya.example.SpringJpaDemo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Student> getAllStudents(String name){

        Sort sort = Sort.by("age").descending(); // appears in descending order

//        List<Student>studentList = studentRepository.findAll(sort);
//
//        for(Student s : studentList){
//            System.out.println(s);
//        }

        Pageable pageable = PageRequest.of(0,3); // displays first 3 names
        Page<Student> studentList = studentRepository.findAll(pageable);

        for(Student s : studentList.getContent()){
            System.out.println(s);
        }

        return studentList.getContent();
    }
}
