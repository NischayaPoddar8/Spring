package org.example;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsService implements NotificationService{
    public void sendNotification(){
        System.out.println("Sms notification sent");
    }
}
