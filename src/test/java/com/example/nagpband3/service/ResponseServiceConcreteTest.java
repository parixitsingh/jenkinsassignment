package com.example.nagpband3.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.nagpband3.service.concrete.ResponseServiceConcrete;

@SpringBootTest
public class ResponseServiceConcreteTest {

	@Autowired
	private ResponseServiceConcrete instance;
	
	@Test
	public void testHelloWorld() {
		String testName = instance.helloWorld();
		Assert.assertEquals("Hello World, I'm Nagp Exercise", testName);
	}
}
