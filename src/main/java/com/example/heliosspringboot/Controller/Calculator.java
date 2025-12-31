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

    @GetMapping("subtract/{cixilan}/{cixan}")
    public int subtract(@PathVariable int cixilan, @PathVariable int cixan){
        return calculatorService.subtract(cixilan,cixan);
    }

    @GetMapping("Multiplication/{vurulan}/{vuran}")
    public int multiplication(@PathVariable int vurulan, @PathVariable int vuran){
        return calculatorService.multiply(vurulan,vuran);
    }

    @GetMapping("division/{bolunen}/{bolen}")
    public int division(@PathVariable int bolunen, @PathVariable int bolen){
        return calculatorService.divide(bolunen,bolen);
    }


}
