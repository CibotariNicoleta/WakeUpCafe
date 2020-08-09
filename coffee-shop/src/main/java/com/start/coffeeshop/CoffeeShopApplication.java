package com.start.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.start.database.MenuRepository;

@SpringBootApplication(scanBasePackages={
"com.start.database", "com.start.loginAndRegistration"})
//@EnableJpaRepositories(basePackages="com.start.database")
@EnableJpaRepositories("com.start.*")
@ComponentScan(basePackages = { "com.start.*" })
@EntityScan("com.start.*")  
public class CoffeeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApplication.class, args);
	}

}
