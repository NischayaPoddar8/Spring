package nischaya.example5.AopMiniProject.service;

import nischaya.example5.AopMiniProject.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order placeOrder(String item, Double price) {
        System.out.println("Executing placeOrder() in OrderServiceImpl");
        return new Order(101L, item, price, "CONFIRMED");
    }

    @Override
    public String cancelOrder(Long orderId) {
        if (orderId < 0) {
            throw new IllegalArgumentException("Invalid Order ID: " + orderId);
        }
        System.out.println("Executing cancelOrder() in OrderServiceImpl");
        return "Order cancelled successfully: " + orderId;
    }

    @Override
    public String getOrderSummary(Long orderId) {
        if (orderId < 0) {
            throw new IllegalArgumentException("Invalid Order ID: " + orderId);
        }
        System.out.println("Executing getOrderSummary() in OrderServiceImpl");
        return "Summary details for order #" + orderId;
    }
}
