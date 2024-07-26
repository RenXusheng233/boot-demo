package com.first.boot.demo.boot_demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping("/hello")
    public List<String> hello() {
        return List.of("hello", "world");
    }
}
