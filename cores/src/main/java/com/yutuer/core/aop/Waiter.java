package com.yutuer.core.aop;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Waiter {

	private Logger logger = Logger.getLogger(Waiter.class);

	@Autowired
	private Seller seller;

	public Waiter() {
		super();
	}

	private void serverTo(){
		logger.info("waiter server to :");
	}

	public void greetTo(String name, String name2) {
		logger.info("waiter greet to :" + name);
		
		
//		seller.serverTo(name, name2); //直接调用被拦截的类的方法, 触发aop
		serverTo(); //this.调用   间接调用,不会触发aop
	}

}
