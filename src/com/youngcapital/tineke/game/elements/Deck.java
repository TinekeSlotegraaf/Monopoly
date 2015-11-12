package com.youngcapital.tineke.game.elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Tineke Class Deck is a deck of cards which are used in a game.
 */
public class Deck {
	private List<Card> cards = new ArrayList<Card>();
	private List<Card> discardPile = new ArrayList<Card>();

	public Deck(String filename) {
		// TODO create the deck given a text file
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		// make sure to catch the exceptions
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] cardData = line.split(cvsSplitBy);
				Card c = new Card(cardData[0], cardData[1]);
				cards.add(c);
				// System.out.println(c.toString());
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
		// shuffle this new deck.
		shuffle(cards);
	}

	/*
	 * method to shuffle the deck
	 */
	public List<Card> shuffle(List<Card> deck) {
		// shuffle the deck
		Collections.shuffle(deck);
		return deck;
	}

	/*
	 * method to return the top card of the pile
	 */
	public Card giveCard() {
		// Give the top card of the pile
		Card c = new Card();
		c = cards.remove(0);
		// check if card can be kept
		if (!c.isCanKeep()) {
			// can't keep it so put it in the discard pile;
			discardPile.add(c);
		}
		// check if deck is empty and shuffle the discard pile into the new deck
		// of cards.
		if (cards.isEmpty()) {
			cards = shuffle(discardPile);
		}
		return c;
	}

	/*
	 * method to return a specific card, used for the tileCards.
	 */
	public Card giveCard(String name) {
		Card c = new Card();
		// loop over all the cards in the deck
		for (Card card : cards) {
			// save the card asked for
			if (card.getName().equals(name)) {
				c = card;
			}
		}
		// return this card.
		return c;
	}

	/*
	 * Method to give the Card back
	 */
	public void returnCard(Card c, boolean backInPile) {
		if (backInPile) {
			cards.add(c);
		} else {
			discardPile.add(c);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String print = "";
		for (Card c : cards) {
			print += " " + c.toString();
		}
		return print;
	}

}
