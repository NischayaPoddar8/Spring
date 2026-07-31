package org.example.payment;
import org.springframework.stereotype.Component;

@Component // Spring manages its bean or (Object) of this class itself
public interface PaymentService {

    public void pay();

        // System.out.println("Payment successful"); --> Now we will change this for other annotations usage to interface

}
