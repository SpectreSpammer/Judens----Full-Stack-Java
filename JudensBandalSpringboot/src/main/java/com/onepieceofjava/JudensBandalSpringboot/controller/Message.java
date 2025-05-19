package com.onepieceofjava.JudensBandalSpringboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Message {

    @GetMapping("/judens")
    public String getMessage(){
        return "Hi Judens, Welcome to Springboot";
    }
}
