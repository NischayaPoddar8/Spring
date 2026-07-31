package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // To start ioc container using annotation configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // The rules of AppConfig.class get used

//        User user = new User("Adi",23);
//        user.getName();
//        user.getAge();
//
//        CartService cart = new CartService();
//        cart.addToCart();

        // Now spring is handling these using bean
        User user = context.getBean(User.class);
        String userName = user.getName();
        System.out.println(userName);
        int userAge = user.getAge();
        System.out.println(userAge);

        CartService cart = context.getBean(CartService.class);
        cart.addToCart();


        OrderService order = context.getBean(OrderService.class); // Without creating object manually spring handles it
        order.placeOrder();

        // Even payment service .pay() command would work because of autowiring

//        PaymentService payment = context.getBean(PaymentService.class);
//        payment.pay();
    }
}
