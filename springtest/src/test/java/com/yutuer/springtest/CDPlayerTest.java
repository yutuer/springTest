package com.yutuer.springtest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yutuer.springtest.config.CDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

	@Rule
	public final SystemOutRule log = new SystemOutRule().enableLog();

	@Autowired
	private CompactDisc disc;

	@Autowired
	private MediaPlayer player;

	@Test
	public void cdShouldNotBeNull() {
		Assert.assertNotNull(disc);
	}

	@Test
	public void play() {
		player.play();
		Assert.assertEquals("Playing Sgt.pepper by The Beatles", log.getLog());
	}

}
