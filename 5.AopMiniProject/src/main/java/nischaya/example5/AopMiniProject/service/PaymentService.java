package nischaya.example5.AopMiniProject.service;

import nischaya.example5.AopMiniProject.annotation.TrackExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @TrackExecutionTime
    public String processPayment(Long orderId, Double amount) {
        System.out.println("Executing processPayment() in PaymentService");
        return "Payment processed successfully for order: " + orderId;
    }

}
