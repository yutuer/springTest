package com.yutuer.core.aop;

import java.lang.reflect.Method;

import org.aopalliance.aop.Advice;
import org.apache.log4j.Logger;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(GreetingAdvisor.class);
	
	public boolean matches(Method method, Class<?> targetClass) {
		logger.info("targetClass:" + targetClass + ", method:" + method.getName());
		return "greetTo".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

	@Autowired
	public void setAdvice(GreetingBeforeAdvice advice) {
		super.setAdvice(advice);
	}

	
}
