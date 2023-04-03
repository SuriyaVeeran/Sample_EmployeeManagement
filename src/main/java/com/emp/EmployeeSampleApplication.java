package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class EmployeeSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSampleApplication.class, args);

	}

}
