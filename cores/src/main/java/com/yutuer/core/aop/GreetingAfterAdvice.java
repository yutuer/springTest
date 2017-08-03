package com.yutuer.core.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class GreetingAfterAdvice implements AfterReturningAdvice {

	private Logger logger = Logger.getLogger(GreetingAfterAdvice.class);

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String clientName = String.valueOf(args[0]);
		logger.info("欢迎下次再来:" + clientName);
	}

}
