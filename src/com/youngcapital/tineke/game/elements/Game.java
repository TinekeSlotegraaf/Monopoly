package com.youngcapital.tineke.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board board = new Board();
	private List<Player> players = new ArrayList<Player>();
	private Dice dice1 = new Dice();
	private Dice dice2 = new Dice();
	private int roll1;
	private int roll2;
	private FreeParking freeParking = new FreeParking();

	/*
	 * Make a Game object by instatiation a player with it's ponn
	 */
	public Game() {
		Player player1 = new Player("Bob");

		// add a ponn for the player to check if it works
		Ponn ponn = new Ponn("boot.jpg", "boot");
		player1.setPonn(ponn);
		players.add(player1);
		
		// take a turn
		//turn();
	}
	
	/*
	 * Getters for the two roll values of the dice.
	 */
	public int getRoll1(){
		return roll1;
	}
	public int getRoll2(){
		return roll2;
	}
	
	public int[] getCoordinates(){
		Player player = players.get(0);
		Ponn ponn = player.getPonn();
		int[] coordinates = ponn.getPlaceOnBoard();
		return coordinates;
	}
	
	

	public int turn() {
		// just throw the dice and add their value's
		// must come at the start of each turn
		int sum = 0;
		roll1 = dice1.getValue();
		roll2 = dice2.getValue();
		sum = roll1 + roll2;
		System.out.println("Sum is " + sum);
		move(players.get(0), sum);
		//System.out.println("your money is: " + player1.getMoney());
		return sum;
	}

	// Than the player needs to move
	public void move(Player player, int sum) {
		Ponn ponn = player.getPonn();
		// the ponn makes sure it stays on the board.
		// it returns the amount of money the player gets (200 when moves over
		// start, otherwise 0)
		int giveMoney = ponn.move(sum);
		player.addMoney(giveMoney);
		// move the ponn
		Tile tile = board.getTile(ponn.getTile());
		ponn.setPlaceOnBoard(tile.getCoordinates());
		// check the tile..
		//checkTile(tile, player, ponn);
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
		case "Go to Jail":
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
		int oldPlace;

		switch (name) {
		case "Go":
			// Ponn is set to 0, Player get's 200 pounds
			ponn.setTile(0);
			player.addMoney(200);
			break;
		case "Jail":
			// Ponn is set to 10, Player cannot move
			ponn.setTile(10);
			player.setCanMove(false);
			break;
		case "PallMall":
			// Ponn is set to 11, check if passes 0
			oldPlace = ponn.getTile();
			if (oldPlace > 11) {
				player.addMoney(200);
			}
			ponn.setTile(11);
			break;
		case "Marylebone":
			// Ponn is set to 15, check if passes 0
			oldPlace = ponn.getTile();
			if (oldPlace > 15) {
				player.addMoney(200);
			}
			ponn.setTile(15);
			break;
		case "Trafalgar":
			// Ponn is set to 24, check if passes 0
			oldPlace = ponn.getTile();
			if (oldPlace > 24) {
				player.addMoney(200);
			}
			ponn.setTile(24);
			break;
		case "Mayfair":
			// Ponn is set to 39
			ponn.setTile(39);
			break;
		case "Back":
			// Ponn is set three steps back
			oldPlace = ponn.getTile();
			int newPlace = oldPlace - 3;
			// if it passes zero the value can't be negative
			if (oldPlace < 2) {
				newPlace = 40 - newPlace;
			}
			ponn.setTile(newPlace);
			break;
		case "Repairs":
			// pay for each house (25) and hotel (100) you have...
			break;
		case "StreetRepairs":
			// pay 40 per house and 115 per hotel
			break;
		case "SchoolFees":
			// pay 150 pounds
			player.subtractMoney(150);
			freeParking.setMoney(150);
			break;
		case "Drunk":
			// pay 20 pounds
			player.subtractMoney(20);
			freeParking.setMoney(20);
			break;
		case "Fine":
			// pay 15 pounds
			player.subtractMoney(15);
			freeParking.setMoney(15);
			break;
		case "LoanMatures":
			// get 150 pounds
			player.addMoney(150);
			break;
		case "WonCompetition":
			// get 100 pounds
			player.addMoney(100);
			break;
		case "Dividend":
			// get 50 pounds from each player
			break;
		case "OutJail":
			// keep in hand, can when in jail
			break;
		case "KentRoad":
			// Ponn goes to 1
			ponn.setTile(1);
			break;
		case "Hospital":
			// pay 100 pounds
			player.subtractMoney(100);
			freeParking.setMoney(100);
			break;
		case "Fee":
			// pay 50
			player.subtractMoney(50);
			freeParking.setMoney(50);
			break;
		case "Insurance":
			// pay 50
			player.subtractMoney(50);
			freeParking.setMoney(50);
			break;
		case "BankError":
			// get 200 pounds
			player.addMoney(200);
			break;
		case "AnnuityMatures":
			// get 100 pounds
			player.addMoney(100);
			break;
		case "Inherit":
			// get 100 pounds
			player.addMoney(100);
			break;
		case "Stock":
			// get 50 pounds
			player.addMoney(50);
			break;
		case "Interest":
			// get 25 pounds
			player.addMoney(25);
			break;
		case "TaxRefund":
			// get 20 pounds
			player.addMoney(20);
			break;
		case "WonContest":
			// get 10 pounds
			player.addMoney(10);
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
