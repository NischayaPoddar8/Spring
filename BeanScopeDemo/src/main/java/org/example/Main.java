package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService order1 = context.getBean(OrderService.class); // 1 bean created here
        // OrderService order2 = context.getBean(OrderService.class);

        // System.out.println(order1==order2); // Singleton bean scope ---> Means IOC container uses only single bean or object by default and doesnt create extra unecessary objects
        // Eager initialization in singleton scope
    }
}