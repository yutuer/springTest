package com.yutuer.core.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestAService {

	protected final Logger logger = Logger.getLogger(TestAService.class);

	@Autowired
	private UserService userService;

	@Transactional(rollbackFor = Exception.class)
	public void testUserService() {
		try {
			userService.testTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
