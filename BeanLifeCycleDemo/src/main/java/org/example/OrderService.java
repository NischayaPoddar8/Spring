package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    // Phase 1: Constructor
    public OrderService() {
        System.out.println("1. [CONSTRUCTOR] OrderService created in memory.");
        // paymentService is still null here
    }

    // Phase 2: Dependency Injection happens behind the scenes here

    // Phase 3: @PostConstruct (Runs after dependencies are injected)
    @PostConstruct
    public void init() {
        System.out.println("2. (@POSTCONSTRUCT) PaymentService has been injected");
        System.out.println("Initializing OrderService setup");
    }

    // Business Method called after post construct
    public void placeOrder() {
        System.out.println("3.Placing order");
        paymentService.pay();
    }

    // Phase 4: @PreDestroy (Runs when app shuts down)
    @PreDestroy
    public void cleanup() {
        System.out.println("4. (@PREDESTROY) OrderService cleaning up resources before app closes.");
    }
}

