package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Contains the rules for application to be set up
@ComponentScan // To scan for components
public class AppConfig {

    @Bean // Now spring will handle it as we cant make component of User class so we use bean annotation to make class ourselves but spring handles it
    public User getUser(){
        return new User("Adi",23);
    }

    @Bean // used above method and component is used above class
    // Bean has more priority over component if both bean and components are placed then bean would be given priority
    public CartService createCartService(){
        return new CartService();
    }
}
