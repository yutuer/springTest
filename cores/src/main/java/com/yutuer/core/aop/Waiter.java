package com.yutuer.core.aop;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("waiter")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Waiter {

	private Logger logger = Logger.getLogger(Waiter.class);

	private String time;
	
	public Waiter() {
		super();
	}

	public Waiter(String time) {
		super();
		this.time = new Date().toLocaleString();
	}

	public void greetTo(String name) {
		logger.info("waiter greet to :" + name);
	}

	public void serverTo(String name) {
		logger.info("waiter server to :" + name);
	}
}
