package com.youngcapital.tineke.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board;
	private List<Player> players = new ArrayList<Player>();
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();

	public Game() {
		board = new Board();
		Player player1 = new Player("Bob");

		// add a ponn for the player to check if it works
		Ponn ponn = new Ponn("reference", "boot");
		player1.setPonn(ponn);
		players.add(player1);
		int sum = 0;
		
		// just throw the dice and add their value's
		// must come at the start of each turn
		while(ponn.getTile() != 2){
		sum = dice1.getValue() + dice2.getValue();
		System.out.println("Sum is " + sum);
		move(players.get(0),sum);
	}
	}


	

	// Than the player needs to move
	public static void move(Player player, int sum) {
		Ponn ponn = player.getPonn();
		// the ponn makes sure it stays on the board.
		ponn.move(sum);
	}

}
