package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    NotificationService notification;

    @Autowired
    OrderService(NotificationService notification){
        this.notification = notification;
    }

    public void placeOrder(){
        System.out.println("Order placed");
        notification.sendNotification();
    }
}
