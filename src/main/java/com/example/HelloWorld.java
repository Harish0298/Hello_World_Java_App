

// src/main/java/com/example/HelloWorld.java
package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloWorld {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);
    }

    @RestController
    class HelloWorldController {

        @GetMapping("/")
        public String sayHello() {
            return "Hello, World!";
        }
    }
}

