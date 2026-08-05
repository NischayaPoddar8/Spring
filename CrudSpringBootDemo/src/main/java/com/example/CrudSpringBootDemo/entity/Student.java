package com.example.CrudSpringBootDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // Used for mapping the class with database managed by spring JPA not IOC
public class Student {

    @Id // For primary key
    private Long id;
    private String name;
    private int age;
    private int rollNo;
    private String emailId;
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
