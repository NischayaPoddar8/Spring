package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        NotificationService notificationService = new SmsNotificationService();
        OrderService order = new OrderService(notificationService);
        order.placeOrder();
    }
}
