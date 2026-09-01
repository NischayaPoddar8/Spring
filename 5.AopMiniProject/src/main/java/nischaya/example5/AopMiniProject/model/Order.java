package nischaya.example5.AopMiniProject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long orderId;

    private String item;
    private Double price;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
