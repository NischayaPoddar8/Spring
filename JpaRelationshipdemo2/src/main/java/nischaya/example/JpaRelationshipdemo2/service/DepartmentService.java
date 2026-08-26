package nischaya.example.JpaRelationshipdemo2.service;

import nischaya.example.JpaRelationshipdemo2.model.Department;
import nischaya.example.JpaRelationshipdemo2.model.Student;
import nischaya.example.JpaRelationshipdemo2.repository.DepartmentRepository;
import nischaya.example.JpaRelationshipdemo2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
