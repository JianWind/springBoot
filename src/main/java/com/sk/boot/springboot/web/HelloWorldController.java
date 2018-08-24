package com.sk.boot.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HelloWorldController")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }
}