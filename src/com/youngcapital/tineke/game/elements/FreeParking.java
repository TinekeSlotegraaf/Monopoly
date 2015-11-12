package com.youngcapital.tineke.game.elements;

public class FreeParking {
	private int money;
	
	public FreeParking(){
		money = 0;
	}

	public int getMoney() {
		int toReturn = money;
		money = 0;
		return toReturn;
	}

	public void setMoney(int money) {
		this.money += money;
	}
	
	
}
