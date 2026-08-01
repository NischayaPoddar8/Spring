package org.example;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
// Stateful class --> Protoype
// Stateless class ---> Singleton
public class B {
    private OrderService orderService;

    public B(OrderService orderService){  // This creates 1 OrderService bean
        this.orderService = orderService;
        System.out.println("B created");
    }
}
