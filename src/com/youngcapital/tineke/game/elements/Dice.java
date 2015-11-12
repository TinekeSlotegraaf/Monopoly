package com.youngcapital.tineke.game.elements;

import java.util.Random;

public class Dice {
	private int value;
	private Random random;
	
	public Dice(){
		random = new Random();
	}
	
	public int getValue(){
		value = random.nextInt(6)+1;
		return value;
	}
}

