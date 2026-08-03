package org.example.ApplicationPropertiesDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationPropertiesDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ApplicationPropertiesDemoApplication.class, args);
//		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//
//		paymentGateway.print();
	}

}
