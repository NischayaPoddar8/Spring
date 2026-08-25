package nischaya.example.JpaRelationshipDemo.service;

import nischaya.example.JpaRelationshipDemo.model.Department;
import nischaya.example.JpaRelationshipDemo.model.Student;
import nischaya.example.JpaRelationshipDemo.repository.DepartmentRepository;
import nischaya.example.JpaRelationshipDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional // Same as transactions of SQL
    public void createStudent(Student student, Long id){ // Existing department
        Department department = departmentRepository.getDepartment(id);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName){ // Assign department while making student
        Department department = new Department();
        department.setName(deptName);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
        departmentRepository.save(department); // Logically we need to first check if department exists then we find its id and save in student
    }
    
}
