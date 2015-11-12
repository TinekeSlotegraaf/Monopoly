package com.youngcapital.tineke.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board = new Board();
	private List<Player> players = new ArrayList<Player>();
	Dice dice1 = new Dice();
	Dice dice2 = new Dice();
	FreeParking freeParking = new FreeParking();

	public Game() {
		Player player1 = new Player("Bob");

		// add a ponn for the player to check if it works
		Ponn ponn = new Ponn("reference", "boot");
		player1.setPonn(ponn);
		players.add(player1);
		int sum = 0;

		// just throw the dice and add their value's
		// must come at the start of each turn
		while (ponn.getTile() != 2 && player1.isCanMove()) {
			sum = dice1.getValue() + dice2.getValue();
			System.out.println("Sum is " + sum);
			move(players.get(0), sum);
			System.out.println("your money is: " + player1.getMoney());

		}
	}

	// Than the player needs to move
	public void move(Player player, int sum) {
		Ponn ponn = player.getPonn();
		// the ponn makes sure it stays on the board.
		ponn.move(sum);
		// check the tile..
		Tile tile = board.getTile(ponn.getTile());
		checkTile(tile, player, ponn);
	}

	// do what is necessary on that tile..
	public void checkTile(Tile tile, Player player, Ponn ponn) {
		String name = tile.getName();
		Card c = new Card();
		// switch over name
		switch (name) {
		case "Chance":
			// take a chance card
			c = board.giveCard("chanceCards");
			checkCard(c, ponn, player);
			System.out.println("Take a chance card");
			break;
		case "Community Chest":
			// take a community chest card
			c = board.giveCard("communityChestCards");
			checkCard(c, ponn, player);
			System.out.println("Take a community chest card");
			break;
		case "Go to jail":
			// move the ponn to 10 + make player.canMove false
			ponn.setTile(10);
			player.setCanMove(false);
			System.out.println("Go to jail, do not pass start");
			break;
		case "Go":
			// get 200 money
			player.addMoney(200);
			System.out.println("On Go, get 200 pounds");
			break;
		case "Income Tax":
			// pay 200 money
			player.subtractMoney(200);
			freeParking.setMoney(200);
			System.out.println("Income Tax: pay 200 pounds");
			break;
		case "Jail":
			// do nothing
			System.out.println("Just visiting the jail");
			break;
		case "Free Parking":
			// get money from FreeParking
			player.addMoney(freeParking.getMoney());
			System.out.println("Get all the money from Free Parking");
			break;
		case "Super Tax":
			// pay 100 money
			player.subtractMoney(100);
			freeParking.setMoney(100);
			System.out.println("Pay super tax: 100 pounds");
			break;
		default:
			// you have something you can buy
			if (tile.isTaken()) {
				// pay rent
				System.out.println("Pay rent");
			} else {
				// want to buy?
				c = board.giveCard("tileCards", tile.getName());
				System.out.println("Want to buy?");
			}
			break;
		}
	}

	/*
	 * Check what the card does and do that.
	 */
	public void checkCard(Card card, Ponn ponn, Player player) {
		String name = card.getName();
		switch (name) {
		case "Go":
			// Ponn is set to 0, Player get's 200 pounds
			break;
		case "Jail":
			// Ponn is set to 10, Player cannot move
			break;
		case "PallMall":
			// Ponn is set to 11, check if passes 0
			break;
		case "Marylebone":
			// Ponn is set to 15, check if passes 0
			break;
		case "Trafalgar":
			// Ponn is set to 24, check if passes 0
			break;
		case "Mayfair":
			// Ponn is set to 39
			break;
		case "Back":
			// Ponn is set three steps back
			break;
		case "Repairs":
			// pay for each house (25) and hotel (100) you have...
			break;
		case "StreetRepairs":
			// pay 40 per house and 115 per hotel
			break;
		case "SchoolFees":
			// pay 150 pounds
			break;
		case "Drunk":
			// pay 20 pounds
			break;
		case "Fine":
			// pay 15 pounds
			break;
		case "LoanMatures":
			// get 150 pounds
			break;
		case "WonCompetition":
			// get 100 pounds
			break;
		case "Dividend":
			// get 50 pounds from each player
			break;
		case "OutJail":
			// keep in hand, can when in jail
			break;
		case "KentRoad":
			// Ponn goes to 1
			break;
		case "Hospital":
			// pay 100 pounds
			break;
		case "Fee":
			// pay 50
			break;
		case "Insurance":
			// pay 50
			break;
		case "BankError":
			// get 200 pounds
			break;
		case "AnnuityMatures":
			// get 100 pounds
			break;
		case "Inherit":
			// get 100 pounds
			break;
		case "Stock":
			// get 50 pounds
			break;
		case "Interest":
			// get 25 pounds
			break;
		case "TaxRefund":
			// get 20 pounds
			break;
		case "WonContest":
			// get 10 pounds
			break;
		case "Birthday":
			// get 10 pounds from each player
			break;
		case "Fine2":
			// pay 10 pounds or take a chance card
			break;
		}
	}
}
