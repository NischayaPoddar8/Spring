package nischaya.example.JpaRelationshipDemo.controller;

import nischaya.example.JpaRelationshipDemo.model.Department;
import nischaya.example.JpaRelationshipDemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withId")
    public ResponseEntity<String> createDepartment(@RequestBody Department department, @RequestParam Long id){
        departmentService.createDepartment(department,id);
        return ResponseEntity.ok("Done");
    }
}
