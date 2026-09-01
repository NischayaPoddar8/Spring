package nischaya.example5.AopMiniProject.aspect;

import nischaya.example5.AopMiniProject.annotation.AuditLog;
import nischaya.example5.AopMiniProject.annotation.TrackExecutionTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAnnotationAspect {

    @Before("@annotation(auditLog)")
    public void beforeAuditLog(JoinPoint joinPoint, AuditLog auditLog){
        System.out.println("AUDIT LOG Action: " + auditLog.action()
                + "  Method: " + joinPoint.getSignature().getName());
    }

    @Around("@annotation(trackExecutionTime)")
    public Object aroundTrackTime(ProceedingJoinPoint joinPoint,
                                TrackExecutionTime trackExecutionTime) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Time taken by " + joinPoint.getSignature().getName() +" : "+ duration);
        return result;
    }
}
