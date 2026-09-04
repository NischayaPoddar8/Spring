package nischaya.example6.JpaRelationshipsTransactionalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderTrackingNo;
    private Double price;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // order is owning side of user
    private User user; //This name and mapped by name shall be same

    @ManyToMany
    @JoinTable(name = "order_products",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product>productList;

    public List<Product> getProductList() {
        if (this.productList == null) {
            this.productList = new ArrayList<>();
        }
        return this.productList;
    }
}
