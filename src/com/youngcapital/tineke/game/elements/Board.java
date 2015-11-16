package com.youngcapital.tineke.game.elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board {
	private Deck chanceCards;
	private Deck communityChestCards;
	private Deck tileCards;
	private List<Tile> tiles = new ArrayList<Tile>();


	public Board() {
		chanceCards = new Deck("G:\\Programming_YoungCapital\\workspace\\Monopoly\\ChanceCards.csv");
		communityChestCards = new Deck("G:\\Programming_YoungCapital\\workspace\\Monopoly\\CommunityChestCards.csv");
		tileCards = new Deck("G:\\Programming_YoungCapital\\workspace\\Monopoly\\TileCards.csv");

		// Read in the data for the Tiles.
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		// make sure to catch the exceptions
		try {
			br = new BufferedReader(
					new FileReader("G:\\Programming_YoungCapital\\workspace\\Monopoly\\OrderOfTiles.csv"));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] cardData = line.split(cvsSplitBy);
				
				// make all the data readable to create a Tile.
				int index = Integer.parseInt(cardData[0]);
				String name = cardData[1];
				int cost = Integer.parseInt(cardData[2]);
				int rent0 = Integer.parseInt(cardData[3]);
				int rent1 = Integer.parseInt(cardData[4]);
				int rent2 = Integer.parseInt(cardData[5]);
				int rent3 = Integer.parseInt(cardData[6]);
				int rent4 = Integer.parseInt(cardData[7]);
				int rent5 = Integer.parseInt(cardData[8]);
				int mortgage = Integer.parseInt(cardData[9]);
				int costHouse = Integer.parseInt(cardData[10]);
				int xCoordinate = Integer.parseInt(cardData[11]);
				int yCoordinate = Integer.parseInt(cardData[12]);
				int[] rent = { rent0, rent1, rent2, rent3, rent4, rent5 };
				int[] coordinates = { xCoordinate, yCoordinate};

				Tile t = new Tile(index, name, cost, rent, mortgage, costHouse, coordinates);
				tiles.add(t);
			//	System.out.println(t.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * Method to return a random card from a deck
	 */
	public Card giveCard(String deckname){
		// control if the name of the deck is one of the decks and return the card asked for
		Card c = new Card();
		if(deckname.equals("chanceCards")){
			c = chanceCards.giveCard();
			System.out.println("Gave a chance card");
			System.out.println(c);
		} else if(deckname.equals("communityChestCards")){
			c = communityChestCards.giveCard();
			System.out.println("Gave a community chest card");
			System.out.println(c);
		}
		return c;
	}
	
	/*
	 * Method to return a specific card from a deck
	 */
	public Card giveCard(String deckName, String cardName){
		Card c = new Card();
		// check if the name of the deck is correct
		if(deckName.equals("tileCards")){
			c = tileCards.giveCard(cardName);
			System.out.println("Gave a tile card");
			System.out.println(c);
		}
		return c;
	}
	
	/*
	 * Method to give a card back to the deck
	 */
	public void returnCard(String deckName, Card card){
		if(deckName.equals("tileCards")){
			tileCards.returnCard(card,true);
			System.out.println("Returned a tile card");
		} else if (deckName.equals("chanceCards")){
			chanceCards.returnCard(card, false);
			System.out.println("Returned a chance card");
		} else if (deckName.equals("communityChestCard")){
			communityChestCards.returnCard(card, false);
			System.out.println("Returned a community chest card");
		}
	}
	
	/*
	 * Method to get the Tile index
	 */
	public Tile getTile(int index){
		return tiles.get(index);
	}
}
