package com.onepieceofjava.Judens_Bandal_Springboot_With_Component.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/component/inventory")
public class inventoryController {

    @GetMapping("/employees")
    public String message(){
        return "Hello Judens";
    }
}
