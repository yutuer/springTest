package com.yutuer.core.service;

import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yutuer.core.dao.LoginLogDao;
import com.yutuer.core.dao.UserDao;
import com.yutuer.core.domain.LoginLog;
import com.yutuer.core.domain.User;
import com.yutuer.core.exception.BusinessException;
import com.yutuer.core.function.UserFunction;

@Service
public class UserService {

	private Logger logger = Logger.getLogger(UserService.class);
	
	private int count;
	
	@Autowired
	private UserFunction userFunction;

	@Autowired
	private LoginLogDao loginLogDao;
	
	@Autowired
	private UserDao userDao;

	public boolean hasMatchUser(String userName, int password) {
		int ret = 0;
		ret = userDao.getMatchCount(userName, password);
		logger.info("hasMatchUser over");
		return ret > 0;
	}

	public User getUser(String userName) {
		return userDao.findUserByUserName(userName);
	}

	public void loginSuccess(User user) {
		user.setCredit(user.getCredit() + 5);
		userDao.updateUser(user);

		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setLoginDate(System.currentTimeMillis());
		loginLog.setIp("192.168.1.99");
		loginLogDao.addLoginLog(loginLog);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Transactional(rollbackFor = Exception.class)
	public void testTransaction() throws Exception {
		String[] strs = new String[] { "yutuer", "aaa", "bbb" };
		for (String str : strs) {
			try {
				userFunction.aaa(str);
			} catch (BusinessException e) {
				e.printStackTrace();
				userFunction.aaa(str);
			}
		}
	}
	
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

}
