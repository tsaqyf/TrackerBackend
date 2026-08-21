package com.example.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dashboard {
    @GetMapping("/")
    public String hello(){
        return "Running cuy";
    }
}
