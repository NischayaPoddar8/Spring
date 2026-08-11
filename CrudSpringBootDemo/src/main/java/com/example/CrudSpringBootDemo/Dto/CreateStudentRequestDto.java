package com.example.CrudSpringBootDemo.Dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {

    @NotBlank(message =  "Name cannot be null empty or blank")
    @Size(min = 2, max = 50, message = "Name shall be between 2 to 50 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value=18, message = "Min age shall be 18 years")
    private int age;

    @NotNull(message = "Roll no is required")
    private int rollNo;

    @NotBlank(message = "Student email cannot be blank")
    @Email(message = "Email must be valid")
    private String emailId;

    @NotNull(message = "Suject name is required")
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
