package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class OnlineBookShopApplication {


	public static void main(String[] args) {
		SpringApplication.run(OnlineBookShopApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
