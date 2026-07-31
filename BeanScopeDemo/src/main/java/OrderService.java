import org.springframework.stereotype.Component;

@Component
public class OrderService {

    public OrderService(){
        System.out.println("Order Created");
    }

    public void placeOrder(){
        System.out.println("Order placed");
    }

}
