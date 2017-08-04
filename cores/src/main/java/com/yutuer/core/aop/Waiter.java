package com.yutuer.core.aop;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Waiter {

	private Logger logger = Logger.getLogger(Waiter.class);

	private String time;

	@Autowired
	private Seller seller;

	public Waiter() {
		super();
	}

	public Waiter(String time) {
		super();
		this.time = new Date().toLocaleString();
	}

	public void greetTo(String name, String name2) {
		logger.info("waiter greet to :" + name);
		seller.serverTo(name, name2);
	}

}
