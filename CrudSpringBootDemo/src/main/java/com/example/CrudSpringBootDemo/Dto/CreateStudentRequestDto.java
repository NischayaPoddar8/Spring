package com.example.CrudSpringBootDemo.Dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank // Name cant be null blank or empty spaces
    private String name;
    @Min(value=18)
    private int age;
    @NotEmpty // Value cant be null or empty but spaces can be there
    private int rollNo;
    @Email
    private String emailId;
    @NotNull
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
