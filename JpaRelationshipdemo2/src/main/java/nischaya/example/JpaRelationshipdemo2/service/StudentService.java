package nischaya.example.JpaRelationshipdemo2.service;

import nischaya.example.JpaRelationshipdemo2.repository.ProfileRepository;
import nischaya.example.JpaRelationshipdemo2.model.Department;
import nischaya.example.JpaRelationshipdemo2.model.Profile;
import nischaya.example.JpaRelationshipdemo2.model.Student;
import nischaya.example.JpaRelationshipdemo2.repository.DepartmentRepository;
import nischaya.example.JpaRelationshipdemo2.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    private ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student){

        Department department = new Department();
        department.setName("CSE");
        student.setDepartment(department);
        Profile profile = new Profile();
        profile.setBio("Hi wssup");
        student.setProfile(profile);
        profileRepository.save(profile);
        departmentRepository.save(department);
        studentRepository.save(student);
    }

    public Student getStudent(Long id){

        Student s = studentRepository.fetchById(id);
        System.out.println("Lazily fetched student");

        Department d = s.getDepartment();
        System.out.println("Lazily fetched department"); // using s we are fetching department

        Profile p = s.getProfile();
        System.out.println("Lazily fetched Profile");

        return s;
    }
}
