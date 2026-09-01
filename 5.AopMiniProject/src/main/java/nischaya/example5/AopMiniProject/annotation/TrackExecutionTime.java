package nischaya.example5.AopMiniProject.annotation;

public @interface TrackExecutionTime {
    long warnAfter() default 2000;
    String operation() default " ";
}
