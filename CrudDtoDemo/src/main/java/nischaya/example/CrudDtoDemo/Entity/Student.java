package nischaya.example.CrudDtoDemo.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Student {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int rollNo;
    private String emailId;
    private String subject;
    private boolean deleted;
}
