package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Every time a new bean is created whenever requireed
// Does lazy intialization
public class OrderService {

    public OrderService(){
        System.out.println("Order Created");
    }

    public void placeOrder(){
        System.out.println("Order placed");
    }

}
