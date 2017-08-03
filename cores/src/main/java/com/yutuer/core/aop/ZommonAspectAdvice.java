package com.yutuer.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10000)
public class ZommonAspectAdvice {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut(value="execution(* com.yutuer.core.aop.Seller.greetTo(..))")
	public void coreMethod() {

	}
	
	@Before(value="coreMethod() && args(name2, name3)")
	public void before(JoinPoint jp, String name2, String name3) {
		logger.info("before jp:" + jp);
		logger.info("before name:" + name2 + name3);
	}
	
	@After(value="coreMethod()")
	public void after(JoinPoint jp) {
		logger.info("after jp:" + jp);
	}
	
//	@Around(value = "coreMethod()")
	public Object doCoreAround(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("doCoreAround pjp:" + pjp);
		return null;
	}
}
