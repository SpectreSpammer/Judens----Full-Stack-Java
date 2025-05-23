package com.onepieceofjava.Judens_Bandal_Springboot_With_Component;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.onepieceofjava.Judens_Bandal_Springboot_With_Component.controller"
})

public class JudensBandalSpringbootWithComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JudensBandalSpringbootWithComponentApplication.class, args);
	}

}
