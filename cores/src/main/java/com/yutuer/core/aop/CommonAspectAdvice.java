package com.yutuer.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonAspectAdvice {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut(value="execution(* com.yutuer.core.aop.Waiter.greetTo(..))")
	public void coreMethod() {

	}
	
	@Before(value="coreMethod()")
	public void before(JoinPoint jp) {
		logger.info("before jp:" + jp);
	}
	
	@After(value="coreMethod()")
	public void after(JoinPoint jp) {
		logger.info("after jp:" + jp.getArgs()[0]);
	}
	
//	@Around(value = "coreMethod()")
	public Object doCoreAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("doCoreAround pjp:" + pjp);
		return null;
	}
}
