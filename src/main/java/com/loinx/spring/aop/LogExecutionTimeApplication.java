package com.loinx.spring.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LogExecutionTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogExecutionTimeApplication.class, args);
	}

}
