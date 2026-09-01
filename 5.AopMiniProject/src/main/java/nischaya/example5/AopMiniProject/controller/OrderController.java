package nischaya.example5.AopMiniProject.controller;

import nischaya.example5.AopMiniProject.model.Order;
import nischaya.example5.AopMiniProject.service.OrderService;
import nischaya.example5.AopMiniProject.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;
    private PaymentService paymentService;

    public OrderController(OrderService orderService, PaymentService paymentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    @GetMapping("/place")
    public Order placeOrder(@RequestParam String item,@RequestParam Double price){
        return orderService.placeOrder(item,price);
    }

    @GetMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Long id){
        return orderService.cancelOrder(id);
    }

    @GetMapping("/summary/{id}")
    public String getOrderSummary(@PathVariable Long id){
        return orderService.getOrderSummary(id);
    }

    @GetMapping("/pay")
    public String processPayment(@RequestParam  Long orderId,@RequestParam Double amount){
        return paymentService.processPayment(orderId,amount);
    }
}
