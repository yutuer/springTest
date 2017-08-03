package com.yutuer.core.aop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yutuer.core.exception.BusinessException;

@Component
@Aspect
@Order(2)
public class ServiceAspectAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// @Pointcut("execution(* com.hutong.bp2.action.*.*(..))")
	@Pointcut("execution(@(org.springframework.transaction.annotation.Transactional) * com.yutuer.core..*(..)) ")
	public void coreMethod() {

	}

	/**
	 * Action方法如果捕获到ConcurrencyException, 那么重试一次,最多重试5次
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@org.aspectj.lang.annotation.Around(value = "coreMethod()")
	public Object doCoreAround(ProceedingJoinPoint pjp) throws Throwable {

		int operateNum = 5;
		Object returns = null;
		for (int num = 0; num < operateNum; num++) {
			try {
				returns = pjp.proceed();
				break;
			} catch (Exception ex) {
				Throwable exception = ex;
				if (InvocationTargetException.class.equals(ex.getClass())) {
					exception = ((InvocationTargetException) ex).getTargetException();
				}
				if (!BusinessException.class.equals(exception.getClass())) {
					throw exception;
				}
				if (num >= (operateNum - 1)) {
					throw exception;
				}
				
				String name = "unknown";
				Signature sig = pjp.getSignature();
				if (sig != null) {
					MethodSignature ms = (MethodSignature) sig;
					if (ms != null) {
						Method m = ms.getMethod();
						if (m != null) {
							name = m.getName();
						}
					}
				}

				logger.error("doCoreAround " + name, exception);
			}
		}
		return returns;
	}

	// @AfterReturning(value="coreMethod()")
	// public void doCoreAfterReturn(){
	// doAfterReturn();
	// }
	//
	//
	// @AfterThrowing(value="coreMethod()")
	// public void doCoreAfterThrow(){
	// doAfterThrow();
	// }
}
