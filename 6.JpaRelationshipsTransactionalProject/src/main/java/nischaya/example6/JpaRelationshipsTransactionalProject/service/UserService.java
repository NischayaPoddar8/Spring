package nischaya.example6.JpaRelationshipsTransactionalProject.service;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Order;
import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Product;
import nischaya.example6.JpaRelationshipsTransactionalProject.entity.User;
import nischaya.example6.JpaRelationshipsTransactionalProject.entity.UserProfile;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.ProductRepo;
import nischaya.example6.JpaRelationshipsTransactionalProject.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepo userRepo; // This handles userProfile as well as order
    private ProductRepo productRepo;

    public UserService(UserRepo userRepo, ProductRepo productRepo) {
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    public void initData(){

        // Initialized products
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setPrice(1200.0);
        product1.setStockQuantity(10);

        Product product2 = new Product();
        product2.setName("Iphone");
        product2.setPrice(1000.0);
        product2.setStockQuantity(8);

        productRepo.saveAll(List.of(product1,product2));

        // User Profile
        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("221B Baker Street");
        userProfile.setPhoneNo("+91-9876543210");

        // User
        User user = new User();
        user.setEmail("john@example.com");
        user.setName("John Doe");
        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        // Orders
        Order order1 = new Order();
        order1.setUser(user);
        order1.setPrice(2200.0);
        order1.setStatus("CONFIRMED");
        order1.setProductList(List.of(product1,product2));
        order1.setOrderTrackingNo("TRK-1001");

        Order order2 = new Order();
        order2.setUser(user);
        order2.setPrice(1000.0);
        order2.setStatus("CONFIRMED");
        order2.setProductList(List.of(product2));
        order2.setOrderTrackingNo("TRK-1002");

        user.setOrderList(List.of(order1,order2));
        userRepo.save(user);
    }

    @Transactional
    public void testLazyLoading(Long userId){

        System.out.println("Fetching user by userId -----");
        User user = userRepo.findById(userId).orElseThrow();
        System.out.println("Fetched user" + user.getName());

        System.out.println("Inspecting class of order list");
        System.out.println(user.getOrderList().getClass().getName());

        System.out.println("Size of order list is " + user.getOrderList().size());

        System.out.println("Accessing products details inside each order");

        for(Order order : user.getOrderList()){
            System.out.println("Fetching order details for order no : " +order.getOrderTrackingNo());
            for(Product p : order.getProductList()){
                System.out.println("Product is : " + p.getName() + "price is " + p.getPrice());
            }
        }
    }

    @Transactional // To test entity graph
    public void testEntityGraph(Long userId){

        System.out.println("Fetching user by userId -----");
        User user = userRepo.findWithOrdersAndProductsById(userId).orElseThrow();
        System.out.println("Fetched user" + user.getName());

        System.out.println("Inspecting class of order list");
        System.out.println(user.getOrderList().getClass().getName());

        System.out.println("Size of order list is " + user.getOrderList().size());

        System.out.println("Accessing products details inside each order");

        for(Order order : user.getOrderList()){
            System.out.println("Fetching order details for order no : " +order.getOrderTrackingNo());
            for(Product p : order.getProductList()){
                System.out.println("Product is : " + p.getName() + "price is " + p.getPrice());
            }
        }
    }

    @Transactional
    public void changeName(Long userId){
        User user = userRepo.findById(userId).orElseThrow();
        System.out.println("Changing name of " + user.getName());
        user.setName("Adam");
        System.out.println("Exiting method -----");
    }

}
