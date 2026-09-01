package nischaya.example5.AopMiniProject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // Any return type any class and any method with any no of parameters in service package can be intercepted
    @Before("execution(* nischaya.example5.AopMiniProject.service.*.*(..))")
    public void beforeLog(JoinPoint joinPoint){
        System.out.println("Before Advice: Intercepted method " + joinPoint.getSignature().getName());
    }
    // joinPoint.getSignature.getName --> returns method name called

    // returning --> returns whatever the particular intercepted method has returned
    @AfterReturning(pointcut = "execution(* nischaya.example5.AopMiniProject.service.*.*(..))",returning ="result")
    public void afterReturningLog(JoinPoint joinPoint,Object result){
        System.out.println("After returning Advice: Intercepted method " + joinPoint.getSignature().getName()
                + " successfully returned -> " + result);
    }

    @AfterThrowing(pointcut = "execution(* nischaya.example5.AopMiniProject.service.*.*(..))",
            throwing = "myError")
    public void afterThrowingLog(JoinPoint joinPoint,Throwable myError){

        System.out.println("AfterThrowing Advice: Method intercepted ["
                + joinPoint.getSignature().getName()
                + "] threw an exception ["
                + myError.getClass().getSimpleName() // returns name of exception
                + "] with message -> "
                + myError.getMessage() // returns error message
        );
    }

    @After("execution(* nischaya.example5.AopMiniProject.service.*.*(..))")
    public void afterLog(JoinPoint joinPoint){
        System.out.println("After Advice: Intercepted method " + joinPoint.getSignature().getName());
    } // Will run even if an exception is thrown like finally block


    public void aroundLog(){

    }
}
