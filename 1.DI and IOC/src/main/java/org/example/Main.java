package org.example;

public class Main {
    static void main() {
        NotificationService notificationService = new SmsNotificationService();
        OrderService order = new OrderService(notificationService);
        order.placeOrder();
    }
}
