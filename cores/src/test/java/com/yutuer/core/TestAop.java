package com.yutuer.core;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.yutuer.core.aop.Seller;
import com.yutuer.core.aop.Waiter;

public class TestAop extends TestBaseCore implements BeanFactoryAware{
	
	private Waiter waiter;

	@Autowired
	private Seller seller;

	private BeanFactory beanFactory;

	@Test
	public void testBefore() {
		waiter = (Waiter)beanFactory.getBean("waiter", "1");
		
		waiter.greetTo("yutuer");
		waiter.serverTo("sam");
		
		seller.greetTo("jack");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
