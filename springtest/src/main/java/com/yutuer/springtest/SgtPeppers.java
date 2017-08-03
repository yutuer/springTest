package com.yutuer.springtest;

public class SgtPeppers implements CompactDisc {

	private String title = "Sgt.pepper";
	private String artist = "The Beatles";

	public void play() {
		System.out.print("Playing " + title + " by " + artist);
	}

}
