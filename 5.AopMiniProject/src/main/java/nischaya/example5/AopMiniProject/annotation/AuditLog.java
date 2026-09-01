package nischaya.example5.AopMiniProject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // Will be available till runtime
public @interface AuditLog {
    String action() default "";
}
