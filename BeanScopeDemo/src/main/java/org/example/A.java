package org.example;

import org.springframework.stereotype.Component;

@Component
public class A {
    private OrderService orderService;

    public A(OrderService orderService){ // 1 bean created here
        this.orderService = orderService;
        System.out.println("A created");
    }

}
