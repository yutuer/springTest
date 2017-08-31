package com.yutuer.core;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yutuer.core.aop.Seller;
import com.yutuer.core.aop.Waiter;

public class TestAop extends TestBaseCore {

	@Autowired
	private Waiter waiter;

	@Autowired
	private Seller seller;

	@Test
	public void testBefore() {
		// 如果不赋予名字,默认的名字是getClass.getSimpleName.firstToLower 即简单类名首字母小写
		waiter.greetTo("yutuer", "yutuer1");
		// waiter.serverTo("yutuer322222");
		seller.greetTo("jack", "jack2122");
	}

}
