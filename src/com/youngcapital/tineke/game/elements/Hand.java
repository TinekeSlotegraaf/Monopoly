package com.youngcapital.tineke.game.elements;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> handCards = new ArrayList<Card>();

	public Hand() {
	}

	public void giveCard(Card c) {
		handCards.add(c);
	}

	public Card returnCard(){
		int index=-1;
		for(int i = 0; i<handCards.size(); i++){
			Card c = handCards.get(i);
			if(c.getName()=="OutJail"){
				index=i;
			}
		}
		if(index==-1){
			//TODO zorgen dat er wat zinvols gereturned wordt als het een andere kaart is.
			return new Card();
		} else{
		return handCards.remove(index);
		}
	}
	
	public List<Card> getCards(){
		return handCards;
	}
}
