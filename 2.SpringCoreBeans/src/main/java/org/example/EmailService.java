package org.example;


import org.springframework.stereotype.Component;

@Component
public class EmailService implements NotificationService{


    public void sendNotification(){
        System.out.println("Email notification sent");
    }
}
