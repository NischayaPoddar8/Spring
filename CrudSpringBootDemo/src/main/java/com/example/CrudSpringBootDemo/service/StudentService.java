package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.Dto.CreateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.CreateStudentResponseDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentResponseDto;
import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.exception.DuplicateResourceException;
import com.example.CrudSpringBootDemo.exception.ResourceNotFoundException;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto){

        Student student = mapToEntity(studentReqDto); // StudentReqDto gets converted into student entity with help of a mapper

        if(emailExists(student)){
            throw new DuplicateResourceException(
                    "Student with email " + student.getEmailId() + "already exists"); // Message to be sent
        }

        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp); // then studentRespDto is mapped and we receive the mapped response
    }

    // Student == id and deleted == false
    public CreateStudentResponseDto getStudent(Long id){

        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Student with id " + id + "not found")
                );

        return mapToDto(studentResp); // Global exception handler will handle
    }

    // Find all and deleted is false also start name from findBy ---> Naming convention for spring to define the method
    public List<CreateStudentResponseDto>getAllStudents(){
        List<Student>studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream().map(this::mapToDto).toList(); // list is converted
    }


    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){

        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Student with id " + id + "not found")
                );

        existingStudent.setName(studentReq.getName()); // We are doing map to entity here
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setUpdatedAt(LocalDateTime.now());

       Student savedStudent = studentRepository.save(existingStudent);
       return mapToUpdateDto(savedStudent);

    }

    public void deleteStudent(Long id){
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Student with id " + id + "not found")
                );// First check if there is record to delete
        studentRepository.delete(studentToBeDeleted);
        return;
    }

    public void softDeleteStudent(Long id){
        // 1. Get details even if the student exists
        Student studentToBeSoftDeleted = studentRepository
                .findByIdAndDeletedIsFalse(id) // It shall not be already marked as deleted
                .orElseThrow(
                        () -> new ResourceNotFoundException("Student with id " + id + "not found")
                );

        // 2. Mark as deleted
        studentToBeSoftDeleted.setDeleted(true);
        // 3. Save
        studentRepository.save(studentToBeSoftDeleted);
    }

    private Student mapToEntity(CreateStudentRequestDto createStudentRequestDto){
        Student student = new Student();

        student.setAge(createStudentRequestDto.getAge());
        student.setName(createStudentRequestDto.getName());
        student.setRollNo(createStudentRequestDto.getRollNo());
        student.setSubject(createStudentRequestDto.getSubject());
        student.setEmailId(createStudentRequestDto.getEmailId());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student){
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setAge(student.getAge());
        responseDto.setEmailId(student.getEmailId());
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student created");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());
        return responseDto;
    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student){
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();

        responseDto.setAge(student.getAge());
        responseDto.setName(student.getName());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setId(student.getId());
        responseDto.setEmailId(student.getEmailId()); // In respons email would be sent as response needs to be full of all required fields
        responseDto.setMessage("Student updated");
        responseDto.setUpdatedAt(LocalDateTime.now());

        return responseDto; // sends response
    }

    private boolean emailExists(Student student){
       return studentRepository.existsByEmailId(student.getEmailId());
    }

}
