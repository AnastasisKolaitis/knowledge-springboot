package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootProjectApplication {

    public static void main(String[] args) {
        System.out.println("Starting MyProjectApplication...");

        SpringApplication.run(MySpringBootProjectApplication.class, args);
    }
}
