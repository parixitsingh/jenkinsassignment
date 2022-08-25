package com.example.nagpband3.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nagpband3.service.InternalService;

@RestController
public class Controller {
	@Autowired
	InternalService internalService;
	
	@GetMapping("/")
	public String helloWorld() {
		return internalService.helloWorld();
	}
}
