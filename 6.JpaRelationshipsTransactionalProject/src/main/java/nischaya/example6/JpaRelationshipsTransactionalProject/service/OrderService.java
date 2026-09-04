package nischaya.example6.JpaRelationshipsTransactionalProject.service;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Order;
import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Product;
import nischaya.example6.JpaRelationshipsTransactionalProject.entity.User;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.OrderRepo;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.ProductRepo;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.desktop.SystemSleepEvent;

@Service
public class OrderService {

    private UserRepo userRepo;
    private OrderRepo orderRepo;
    private ProductRepo productRepo;
    private AuditService auditService;

    public OrderService(UserRepo userRepo,
                        OrderRepo orderRepo,
                        ProductRepo productRepo,
                        AuditService auditService) {
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.auditService = auditService;
    }

    @Transactional
    public void processFailedOrder(Long userId, Long productId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStockQuantity(product.getStockQuantity() - 1);

        Order order = new Order();
        order.setOrderTrackingNo("TRK-FAIL-999");
        order.setStatus("PENDING");
        order.setPrice(product.getPrice());

        order.setUser(user);
        order.getProductList().add(product);

        orderRepo.save(order);
        auditService.log("ORDER_FAILURE_SIMULATION", "Payment gateway timed out for user ID: " + userId);

        throw new RuntimeException("Payment Gateway Unreachable!");
    }
}
