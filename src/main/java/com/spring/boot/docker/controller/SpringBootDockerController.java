package com.spring.boot.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootDockerController {
	@RequestMapping("/")
	public String homePage() {
		return "Spring Boot and Docker Demo Application";
	}
}
