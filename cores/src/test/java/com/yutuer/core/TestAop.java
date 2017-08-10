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
		//如果不赋予名字,默认的名字是getClass.getSimpleName.firstToLower 即简单类名首字母小写 
		waiter = (Waiter)beanFactory.getBean("waiter", "1");
		
		waiter.greetTo("yutuer", "yutuer1");
//		waiter.serverTo("yutuer322222");
		seller.greetTo("jack", "jack2122");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
