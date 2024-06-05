package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class EmployeeManagementApplication {
	public static void generateOtp() {
		Random random = new Random();
		StringBuilder otp = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			otp.append(random.nextInt(10));
		}
		System.out.println( "OTP is : "+otp.toString());
	}

	public static void main(String[] args) {
		generateOtp();
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
