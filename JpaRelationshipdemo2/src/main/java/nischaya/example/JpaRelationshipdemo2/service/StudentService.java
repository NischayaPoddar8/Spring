package nischaya.example.JpaRelationshipdemo2.service;

import nischaya.example.JpaRelationshipdemo2.model.Department;
import nischaya.example.JpaRelationshipdemo2.model.Student;
import nischaya.example.JpaRelationshipdemo2.repository.DepartmentRepository;
import nischaya.example.JpaRelationshipdemo2.repository.StudentRepository;
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
    public void createStudent(Student student, Long dept_id){ // Existing department
        Department department = departmentRepository.getDepartment(dept_id);
        student.setDepartment(department);
        department.getStudents().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student, String deptName) {

        // 1. Create and save the department first
        Department department = new Department(); // if department does not exist we need to check it
        department.setName(deptName);
        Department savedDepartment = departmentRepository.save(department);

        // 2. Link the saved department to the student
        student.setDepartment(savedDepartment);

        studentRepository.save(student);
        savedDepartment.getStudents().add(student);
    }

}
