package com.example.nagpband3.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.nagpband3.service.impl.InternalServiceImpl;

@SpringBootTest
public class InternalServiceImplTest {

	@Autowired
	private InternalServiceImpl internalServiceImpl;
	
	@Test
	public void testHelloWorld() {
		String testName = internalServiceImpl.helloWorld();
		Assert.assertEquals("Hello World", testName);
	}
}
