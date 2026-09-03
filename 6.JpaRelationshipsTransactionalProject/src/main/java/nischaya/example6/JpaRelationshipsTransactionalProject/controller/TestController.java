package nischaya.example6.JpaRelationshipsTransactionalProject.controller;

import nischaya.example6.JpaRelationshipsTransactionalProject.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class TestController {

    private UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/seed")
    public String seedData(){
        userService.initData();
        return "Data seeded";
    }
}
