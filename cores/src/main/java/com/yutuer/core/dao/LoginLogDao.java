package com.yutuer.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yutuer.core.domain.LoginLog;

@Repository
public class LoginLogDao extends CommonDao<LoginLog> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void addLoginLog(LoginLog loginLog) {
		String sql = "insert into t_loginLog(userid, ip, loginDate) values (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() });
	}

}
