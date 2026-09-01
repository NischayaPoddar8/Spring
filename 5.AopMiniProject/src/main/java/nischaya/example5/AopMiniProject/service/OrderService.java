package nischaya.example5.AopMiniProject.service;

import nischaya.example5.AopMiniProject.model.Order;

public interface OrderService {

    public Order placeOrder(String item, Double price);
    public String cancelOrder(Long orderId);
    public String getOrderSummary(Long orderId);
}
