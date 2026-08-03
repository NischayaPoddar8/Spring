package org.example.ApplicationPropertiesDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
//    private String type;
//    private int retryCount;

    // We will use application properties to set values using value annotation
//    public PaymentGateway(@Value("${paymentGateway.type :Paytm}") String type, @Value("${paymentGateway.retry-count}")int retryCount) {
//        this.type = type;
//        this.retryCount = retryCount;
//    }
    private paymentProperties paymentProperties;

    public PaymentGateway(paymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public void setType(String type) {
        paymentProperties.setType(type);
    }

    public void setRetryCount(int retryCount) {
        paymentProperties.setRetryCount(retryCount);
    }

    public boolean isEnabled(){
        return paymentProperties.isEnabled();
    }

    public int getTimeOut(){
        return paymentProperties.getTimeout();
    }

    public void print(){
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getTimeOut());
        System.out.println(isEnabled());
    }

}
