package com.example.nagpband3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.nagpband3.service.ResponseService;

@RestController
public class HttpController {
	@Autowired
	ResponseService execService;
	
	@GetMapping("/")
	public String helloWorld() {
		return execService.helloWorld();
	}

	@GetMapping("/healthz")
	@ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public String healthz(){
		return "StatusOk";
	}
}
