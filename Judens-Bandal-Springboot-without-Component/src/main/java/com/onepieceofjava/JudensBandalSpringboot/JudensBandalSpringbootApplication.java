package com.onepieceofjava.JudensBandalSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.onepieceofjava.JudensBandalSpringboot.controller"
})
public class JudensBandalSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JudensBandalSpringbootApplication.class, args);
	}

}
