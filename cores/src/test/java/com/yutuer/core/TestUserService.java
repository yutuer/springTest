package com.yutuer.core;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yutuer.core.domain.User;
import com.yutuer.core.service.UserService;

public class TestUserService extends TestBaseCore {

	@Autowired
	private UserService userService;

	// @Test
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("yutuer", 111);
		Assert.assertTrue(b1);
		// boolean b2 = userService.hasMatchUser("yutuer", 123456);
		// Assert.assertFalse(b2);
	}

	public void findUserByUserName() {
		User user = userService.getUser("yutuer");
		Assert.assertEquals(user.getPassword(), 111);
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setPassword(111);
		user.setUserName("yutuer");
		user.setCredit(5);
		user.setVersion(UUID.randomUUID().toString());
		userService.addUser(user);
	}

}
