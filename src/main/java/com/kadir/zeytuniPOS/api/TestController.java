package com.kadir.zeytuniPOS.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "ZeytuniPOS Spring Boot API";
    }
}