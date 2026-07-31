package org.example;

public class OrderService {

    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification; // Not creating object of NotificationService
    }

    public void placeOrder(){
        System.out.println("Order placed");
        notification.sendNotification();
    }
}
