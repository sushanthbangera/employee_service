package com.glarimy.quiz.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuizEmployeeService {

	public static void main(String[] args) {
		SpringApplication.run(QuizEmployeeService.class, args);
	}

}
