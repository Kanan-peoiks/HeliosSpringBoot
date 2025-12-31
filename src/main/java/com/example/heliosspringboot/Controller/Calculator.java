package com.example.heliosspringboot.Controller;

import com.example.heliosspringboot.Service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    private final CalculatorService calculatorService;

    public Calculator(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
//idarəetməni springə vermək Inversion of Control
// Dependency Injection - lazım olan tərəfin lazım olan yerə ötürülməsi

    @GetMapping("add/{toplanan1}/{toplanan2}")
    public int add(@PathVariable int toplanan1, @PathVariable int toplanan2){
    return calculatorService.add(toplanan1,toplanan2);
    }


}
