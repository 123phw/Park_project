package com.example.parkprjct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class ParkprjctApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkprjctApplication.class, args);
    }

}
