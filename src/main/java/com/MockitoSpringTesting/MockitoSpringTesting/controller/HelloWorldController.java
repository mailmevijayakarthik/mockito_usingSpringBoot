package com.MockitoSpringTesting.MockitoSpringTesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/myworld")
    public String Helloworld(){

        return "Hello Vijay welcome to the world";
    }
}
