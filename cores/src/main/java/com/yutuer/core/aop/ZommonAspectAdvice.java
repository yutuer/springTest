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

//@Component
//@Aspect
public class ZommonAspectAdvice {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut(value="execution(* com.yutuer.core.aop.Seller.serverTo(..))")
	public void coreMethod() {

	}
	
	//可以定义2个
	@Before(value="coreMethod()")
	public void before(JoinPoint jp) {
		//先进通用的
		logger.info("before jp:" + jp);
	}
	
	//这里如果加上args,参数数量要一致
	@Before(value="coreMethod() && args(name, name1)")
	public void before(JoinPoint jp, String name, String name1) {
		//再进特殊的
		logger.info("before jp:" + jp);
		//能取到被拦截方法调用的参数
		logger.info("before jp name:" + name);
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
