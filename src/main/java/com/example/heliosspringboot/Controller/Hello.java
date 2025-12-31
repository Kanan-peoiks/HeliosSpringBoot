package com.example.heliosspringboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

@GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/sum")
    public int sum(@RequestParam int a,
                   @RequestParam int b) {
        return a + b;
    }
}
