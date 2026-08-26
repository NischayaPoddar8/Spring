package nischaya.example.JpaRelationshipDemo.service;

import nischaya.example.JpaRelationshipDemo.model.Department;
import nischaya.example.JpaRelationshipDemo.model.Student;
import nischaya.example.JpaRelationshipDemo.repository.DepartmentRepository;
import nischaya.example.JpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department,String studentName){
        Student student = new Student(); // Consider we are adding new student
        student.setName(studentName);
        student.setDepartment(department);

        department.getStudents().add(student);
        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
