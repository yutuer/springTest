package com.yutuer.core.function;

import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yutuer.core.dao.UserDao;
import com.yutuer.core.domain.User;
import com.yutuer.core.exception.BusinessException;
import com.yutuer.core.service.UserService;

@Component
public class UserFunction {

	private Logger logger = Logger.getLogger(UserFunction.class);

	private int count;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Transactional(rollbackFor = Exception.class)
	public void aaa(String userName) throws Exception {
		User user = userDao.findUserByUserName(userName);
		user.setVersion(UUID.randomUUID().toString());
		user.setPassword(new Random().nextInt(1000));
		userDao.updateUser(user);
		if (this.count++ == 1) {
			throw new BusinessException("抛异常");
		}
		logger.info("testTransaction over:" + userName);
	}

	@Transactional(rollbackFor = Exception.class)
	public void transfer(String userName) throws Exception {
		userService.aaa(userName);
	}
}
