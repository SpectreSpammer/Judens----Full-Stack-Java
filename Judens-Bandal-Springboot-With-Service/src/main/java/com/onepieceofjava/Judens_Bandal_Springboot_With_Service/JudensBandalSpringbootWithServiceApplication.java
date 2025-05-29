package com.onepieceofjava.Judens_Bandal_Springboot_With_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.onepieceofjava.Judens_Bandal_Springboot_With_Service"
})
@EntityScan("com.onepieceofjava.Judens_Bandal_Springboot_With_Service.model")
@EnableJpaRepositories("com.onepieceofjava.Judens_Bandal_Springboot_With_Service.repository")
public class JudensBandalSpringbootWithServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JudensBandalSpringbootWithServiceApplication.class, args);
	}

}
