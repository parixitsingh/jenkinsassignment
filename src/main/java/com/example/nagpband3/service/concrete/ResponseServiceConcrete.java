package com.example.nagpband3.service.impl;

import org.springframework.stereotype.Service;

import com.example.nagpband3.service.ResponseService;

@Service
public class ResponseServiceConcrete implements ResponseService {

	@Override
	public String helloWorld() {
		return "Hello World";
	}

}
