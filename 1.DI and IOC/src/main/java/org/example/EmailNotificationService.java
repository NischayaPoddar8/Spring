package org.example;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(){
        System.out.println("Email Notification sent");
    }
}
