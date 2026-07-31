package org.example;

public class SmsNotificationService implements NotificationService{
    @Override
    public void sendNotification(){
        System.out.println("SMS Notification sent");
    }
}
