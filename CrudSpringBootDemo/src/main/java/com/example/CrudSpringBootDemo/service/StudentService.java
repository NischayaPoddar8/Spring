package com.example.CrudSpringBootDemo.service;

import com.example.CrudSpringBootDemo.Dto.CreateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.CreateStudentResponseDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentRequestDto;
import com.example.CrudSpringBootDemo.Dto.UpdateStudentResponseDto;
import com.example.CrudSpringBootDemo.entity.Student;
import com.example.CrudSpringBootDemo.exception.ResourceNotFoundException;
import com.example.CrudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
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
        Student student = mapToEntity(studentReqDto); // StudentReqDto gets converted into student entity with help of a mapper class
        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp); // then studentRespDto is mapped and we receive the mapped response
    }

    // Student == id and deleted == false
    public CreateStudentResponseDto getStudent(Long id){
        // Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id); // If such record does not exist to stay safe we use optional student which can be null as well
//        if(studentResp.isPresent()){
//            return mapToDto(studentResp.get());
//        }
        // return null;
        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Student with id " + id + "not found") );

        return mapToDto(studentResp); // Global exception handler will handle
    }

    // Find all and deleted is false also start name from findBy ---> Naming convention for spring to define the method
    public List<CreateStudentResponseDto>getAllStudents(){
        List<Student>studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream().map(this::mapToDto).toList(); // list is converted
    }


    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id); // If such record does not exist we cant update then
        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setUpdatedAt(LocalDateTime.now());

       Student savedStudent = studentRepository.save(studentToSave);
       return mapToUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id); // First check if there is record to delete
        if (!isStudent){
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    public Boolean softDeleteStudent(Long id){
        // 1. Get details even if the student exists
        Optional<Student>existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);
        if (existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        // 2. Mark as deleted
        studentToSave.setDeleted(true);
        // 3. Save
        studentRepository.save(studentToSave);
        return true; // Soft deleted
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
}
