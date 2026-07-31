package org.example;
import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

   // PaymentService payment;  // No need of this spring handles it as it knows it needs to create beans of component

//    OrderService(PaymentService payment){
//        this.payment = payment;
//    }

    // @Autowired ---> Filed injection
    private PaymentService payment;

       // Constructor Injection
       @Autowired         // Autowire wires bean of payment here ---> With single constructor there is no need of autowired
    OrderService(@Qualifier("upi") PaymentService payment){
        this.payment = payment; // Here always autowiring will cause the beans commands to be implemented first
    }

    // @Autowired Setter Injection
//    public void setPayment(PaymentService payment) {
//        this.payment = payment;
//    }

    public void placeOrder(){
        // payment.pay(); // Order is placed as payment happened
        payment.pay();
        System.out.println("Order Placed");
    }
}
