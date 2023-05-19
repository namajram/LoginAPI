package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.api.entity,"+"com.api.controller,"+"com.api.repository,"+"com.api.service,"+"com.api.sevice.impl,"+"com.api.util,"+"com.api.securityconfig"})
public class ThinrootTask1Application {

	public static void main(String[] args) {
		SpringApplication.run(ThinrootTask1Application.class, args);
	}

}
