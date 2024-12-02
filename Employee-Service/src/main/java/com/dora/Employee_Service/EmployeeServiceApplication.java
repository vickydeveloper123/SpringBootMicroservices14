package com.dora.Employee_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
@EnableFeignClients
		(basePackages = "com.dora.Employee_Service.service")
public class EmployeeServiceApplication {




	public static void main(String[] args) {



		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("employee service application has been sucessfully ");
	}

}
