package com.spring.spring_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/home")
    public String index(){
        return "";
    }
}
