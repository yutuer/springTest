package com.yutuer.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yutuer.core.service.TestAService;

public class TestTransaction extends TestBaseCore {

	@Autowired
	private TestAService testAService;

	@Test
	public void testA() {
		testAService.testUserService();
	}
}
