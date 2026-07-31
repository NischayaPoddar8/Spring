package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello") // For get method mapping if someone adds /hello we do not need to call from object
    public String Hello(){
        return "Hello from HelloController";
    }

    @GetMapping("bye")
    public String Bye(){
        return "Bye from HelloController";
    }
}
