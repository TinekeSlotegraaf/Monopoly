package com.youngcapital.tineke.game.elements;

public class Player {
	private String name;
	private Ponn ponn;
	private Hand hand;
	private int money;
	private boolean canMove = true;
	
	public Player(String name){
		this.name = name;
		// also ask which ponn they want and save that.
		money = 1500;
		hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ponn getPonn() {
		return ponn;
	}

	public void setPonn(Ponn ponn) {
		this.ponn = ponn;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isCanMove() {
		return canMove;
	}

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}
	
	

}
