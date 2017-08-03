package com.yutuer.springtest;

import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer implements MediaPlayer {

	@Autowired
	private CompactDisc disc;

	public CDPlayer() {
		super();
	}

	public void play() {
		disc.play();
	}

}
