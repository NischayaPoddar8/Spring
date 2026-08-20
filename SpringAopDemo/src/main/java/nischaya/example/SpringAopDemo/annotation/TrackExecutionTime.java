package nischaya.example.SpringAopDemo.annotation;

import java.lang.annotation.*;

// Marker annotation
@Target(ElementType.METHOD) // Can only be applied to methods
@Retention(RetentionPolicy.RUNTIME) // Will be available till runtime
public @interface TrackExecutionTime { // @interface --> to tell it is an annotation
     long warnAfter() default 2000;
     String operation() default " ";
}
