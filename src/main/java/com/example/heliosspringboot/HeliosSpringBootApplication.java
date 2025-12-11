package com.example.heliosspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HeliosSpringBootApplication {

    public static void main(String[] args) {
        // Spring konteynerini işə salır
        ApplicationContext context = SpringApplication.run(HeliosSpringBootApplication.class, args);

        // Spring-dən PaymentProcessor bean-ni götürürük
        PaymentProcessor processor = context.getBean(PaymentProcessor.class);

        // 150 AZN ödənişi edirik
        processor.processPayment(150.00);
    }
}
