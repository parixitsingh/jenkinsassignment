package com.example.nagpband3.service.impl;

import org.springframework.stereotype.Service;

import com.example.nagpband3.service.InternalService;

@Service
public class InternalServiceImpl implements InternalService {

	@Override
	public String helloWorld() {
		return "Hello World";
	}

}
