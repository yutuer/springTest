package com.yutuer.core.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	private Logger logger = Logger.getLogger(GreetingBeforeAdvice.class);

	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info(target.getClass().getName() + "." + method.getName());
		String clientName = String.valueOf(args[0]);
		logger.info("How are you: Mr." + clientName);
	}

}
