package com.youngcapital.tineke.game.elements;

public class Hotel {
	private static int numberAvailable = 12;
	
	public Hotel(){
		if(numberAvailable > 0){
			numberAvailable -= 1;
		}
		// TODO make an else for when no more Hotels are available.
	}
}
