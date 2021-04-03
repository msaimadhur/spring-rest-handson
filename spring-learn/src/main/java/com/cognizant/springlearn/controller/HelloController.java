package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class HelloController {
	public static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.debug("Start");
		return "Hello World!!";
	}
}
