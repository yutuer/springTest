package com.yutuer.core.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CommonDao<T> {

	protected final Logger logger = Logger.getLogger(CommonDao.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public CommonDao() {
		super();
//		Type type = getClass().getGenericSuperclass();
//		ParameterizedType pt = ParameterizedType.class.cast(type);
//		Type t = pt.getActualTypeArguments()[0];
//		Class.class.cast(t);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

}
