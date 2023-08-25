package com.gym.gymportal;

import org.springframework.web.bind.annotation.RequestMapping;

public class Hellow {
	@RequestMapping("/hello")
	public String hello() {
		return "Welcome to Spring Boot and REST API Development";
	}
}
