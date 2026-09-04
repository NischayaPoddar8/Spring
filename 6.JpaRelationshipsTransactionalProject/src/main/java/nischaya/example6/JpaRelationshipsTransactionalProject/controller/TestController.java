package nischaya.example6.JpaRelationshipsTransactionalProject.controller;

import nischaya.example6.JpaRelationshipsTransactionalProject.entity.Order;
import nischaya.example6.JpaRelationshipsTransactionalProject.service.OrderService;
import nischaya.example6.JpaRelationshipsTransactionalProject.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class TestController {

    private UserService userService;
    private OrderService orderService;

    public TestController(UserService userService, OrderService orderService) {

        this.userService = userService;
        this.orderService = orderService;

    }

    @GetMapping("/seed")
    public String seedData(){
        userService.initData();
        return "Data seeded";
    }

    @GetMapping("/test-lazy/{id}")
    public String lazyFetch(@PathVariable  Long id){
        userService.testLazyLoading(id);
        return "Fetched Lazily";
    }

    @GetMapping("/test-entity/{id}")
    public String entityGraphFetch(@PathVariable Long id){
        userService.testEntityGraph(id);
        return "Fetched via Entity graph";
    }

    @GetMapping("/change-name/{id}")
    public String changeName(@PathVariable Long id){
        userService.changeName(id);
        return "Change name called";
    }

    @GetMapping("/rollback-test")
    public String changeStock(@RequestParam Long userId, @RequestParam Long productId){
        orderService.processFailedOrder(userId,productId);
        return "Changed stock quantity";
    }
}
