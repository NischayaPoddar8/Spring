package com.example.CrudSpringBootDemo.repository;

import com.example.CrudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    public Optional<Student>findByIdAndDeletedIsFalse(Long id);
    public List<Student>findByDeletedIsFalse();
}
