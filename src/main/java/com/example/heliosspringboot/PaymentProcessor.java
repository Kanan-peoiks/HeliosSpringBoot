package com.example.heliosspringboot;

import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    public void processPayment(double amount) {
        System.out.println("Məbləğ ödənilir: " + amount + " AZN");
    }
}
