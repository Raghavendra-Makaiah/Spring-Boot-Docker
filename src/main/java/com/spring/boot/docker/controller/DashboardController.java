package com.spring.boot.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "Welcome to My Dashboard";
	}
}
