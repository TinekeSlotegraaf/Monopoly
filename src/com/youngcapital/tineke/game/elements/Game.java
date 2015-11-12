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
		move(players.get(0),sum, board);

		}
	}

	// Than the player needs to move
	public void move(Player player, int sum, Board board) {
		Ponn ponn = player.getPonn();
		// the ponn makes sure it stays on the board.
		ponn.move(sum);
		// check the tile..
		Tile tile = board.getTile(ponn.getTile());
		checkTile(tile);
	}
	
	// do what is necessary on that tile..
		public void checkTile(Tile tile) {
			String name = tile.getName();
			// switch over name
			switch (name) {
			case "Chance":
				// take a chance card
				System.out.println("Take a chance card");
				break;
			case "Community Chest":
				// take a community chest card
				System.out.println("Take a community chest card");
				break;
			case "Go to jail":
				// move the ponn to 10 + make player.canMove false
				System.out.println("Go to jail, do not pass start");
				break;
			case "Go":
				// get 200 money
				System.out.println("On Go, get 200 pounds");
				break;
			case "Income Tax":
				// pay 200 money
				System.out.println("Income Tax: pay 200 pounds");
				break;
			case "Jail":
				// do nothing
				System.out.println("Just visiting the jail");
				break;
			case "Free Parking":
				// get money from FreeParking
				System.out.println("Free parking, get all the money");
				break;
			case "Super Tax":
				// pay 100 money
				System.out.println("Pay super tax: 100 pounds");
				break;
			default:
				// you have something you can buy
				if(tile.isTaken()){
					// pay rent
					System.out.println("Pay rent");
				} else{
					// want to buy?
					System.out.println("Want to buy?");
				}
				break;
			}
		}

}
