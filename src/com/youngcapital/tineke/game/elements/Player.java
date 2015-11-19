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
	
	/*
	 * method to add money
	 */
	public void addMoney(int money){
		this.money += money;
	}
	
	/*
	 * method to subtract money
	 */
	public void subtractMoney(int money){
		// only do this when there is enough money...
		// TODO iets maken dat zorgt dat mensen game over gaan als ze niet kunnen betalen.
		this.money -= money;
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
	
	public void giveCard(Card card){
		hand.giveCard(card);
	}
	
	

}
