package nischaya.example.SpringAopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {

    @Before("execution(String nischaya.example.SpringAopDemo.service.StudentService.getStudent(String))")
    public void beforeLog(){
        System.out.println("Method intercepted before get service");
    }
}
