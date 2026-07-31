package org.example.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary // In case of 2 beans this will be preferred
@Qualifier("cp") // It is like an assigned name so in case of multiple beans this is a better approach than primary
public class CardPayment implements PaymentService{
    public void pay(){
        System.out.println("Paid via card");
    }
}
