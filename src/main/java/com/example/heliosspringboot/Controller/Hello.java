package com.example.heliosspringboot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

@GetMapping("giris")
    public String welcome(){
        return "Welcome to Spring Boot!";
    }

    @GetMapping("salamla")
    public String hello(){
        return "hello";
    }


    @GetMapping("cixis")
    public String goodbye(){
        return "GOODBYE";
    }
}
