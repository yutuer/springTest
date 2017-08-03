package com.yutuer.core;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:core.xml" })
public class TestBaseCore {

	public Logger logger = Logger.getLogger(TestBaseCore.class);

}
