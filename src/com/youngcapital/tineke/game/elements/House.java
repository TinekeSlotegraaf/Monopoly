package com.youngcapital.tineke.game.elements;

public class House {
	private static int numberAvailable = 32;
	
	public House(){
		if(numberAvailable > 0){
			numberAvailable -= 1;
		}
		// TODO make an else for when no more Hotels are available.
	}
}
