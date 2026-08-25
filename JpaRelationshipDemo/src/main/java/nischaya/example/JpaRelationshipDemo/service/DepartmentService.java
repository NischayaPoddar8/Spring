package nischaya.example.JpaRelationshipDemo.service;

import nischaya.example.JpaRelationshipDemo.model.Department;
import nischaya.example.JpaRelationshipDemo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, Long id){
        departmentRepository.saveWithId(department,id);
    }
}
