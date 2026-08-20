package nischaya.example.SpringAopDemo.aspect;

import nischaya.example.SpringAopDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect {

//    @Before("execution(String nischaya.example.SpringAopDemo.service.StudentService.getStudent(String))")
//    public void beforeLog(){
//        System.out.println("Method intercepted before get service");
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime) throws Throwable {
        Long startTime = System.currentTimeMillis();

        try{
            return joinPoint.proceed();
        }
        finally {
            Long endTime = System.currentTimeMillis();
            Long duration = endTime-startTime;

            String operation = trackExecutionTime.operation();
            Long warnTime = trackExecutionTime.warnAfter();
            String methodName = joinPoint.getSignature().getName();
            
            if(warnTime<duration){
                System.out.println("Taken too much time");
                System.out.println("Time taken by method : " + methodName + " " + duration);
            }

            else System.out.println("Time taken by method : " + methodName + " " + duration);
        }
    }
}
