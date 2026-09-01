package nischaya.example5.AopMiniProject.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String processPayment(Long orderId, Double amount) {
        System.out.println("Executing processPayment() in PaymentService");
        return "Payment processed successfully for order: " + orderId;
    }

}
