package nischaya.example.SpringAopDemo.service;

import nischaya.example.SpringAopDemo.annotation.TrackExecutionTime;
import nischaya.example.SpringAopDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(operation = "Post student")
    public Student createStudent(Student student){
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(warnAfter = 1500 ,operation = "Get student")
    public String getStudent(String s){

        try{
            Thread.sleep(2000);
        }
        catch(Exception exception){
            // We put the thread on sleep for 2 seconds to see if our annotation measures time
        }

        System.out.println(s);
        return s;
    }

}
