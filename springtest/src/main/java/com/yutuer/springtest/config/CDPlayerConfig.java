package com.yutuer.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yutuer.springtest.CDPlayer;
import com.yutuer.springtest.CompactDisc;
import com.yutuer.springtest.MediaPlayer;
import com.yutuer.springtest.SgtPeppers;

@Configuration
public class CDPlayerConfig {

	@Bean
	public CompactDisc getCompactDisc() {
		return new SgtPeppers();
	}

	@Bean
	public MediaPlayer getMediaPlayer() {
		return new CDPlayer();
	}
}
