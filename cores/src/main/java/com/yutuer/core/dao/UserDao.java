package com.yutuer.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.yutuer.core.domain.User;

@Repository
public class UserDao extends CommonDao<User> implements InitializingBean{

	private int i;

	public void afterPropertiesSet() throws Exception {
		logger.info("不知道干嘛的");
	}

	public int getMatchCount(String userName, int password) {
		String sqlStr = "Select count(*) from t_user where userName=? and password= ? ";
		int ret = getJdbcTemplate().queryForObject(sqlStr, new Object[] { userName, password }, int.class);
		return ret;
	}

	public void testRollBackOnly() {
		try {
			throwException();
		} catch (Exception e) {
			logger.error("here is a Exception", e);
		}
	}

	public void throwException() {
		if (i++ == 0) {
			throw new RuntimeException("my throw exception");
		}
	}

	public void addUser(User user) {
		String sql = "insert into t_user(password, userName, credit, version) values(?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { user.getPassword(), user.getUserName(), user.getCredit(), user.getVersion() });
	}

	public User getUser(final long userId) {
		String sql = "select password, username from t_user where userid=?";
		final User user = new User();
		getJdbcTemplate().query(sql, new Object[] { userId }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(userId);
				user.setPassword(rs.getInt("password"));
				user.setUserName(rs.getString("username"));
			}
		});
		return user;
	}

	public User findUserByUserName(String userName) {
		String sql = "select userid from t_user where userName=?";
		Long userId = getJdbcTemplate().queryForObject(sql, new Object[] { userName }, Long.class);
		return getUser(userId);
	}

	public void updateUser(User user) {
		String sql = "update t_user set password=?, credit=?, version=?  where userid=?";
		getJdbcTemplate().update(sql, new Object[] { user.getPassword(), user.getCredit(), user.getVersion(), user.getUserId() });
	}
}
