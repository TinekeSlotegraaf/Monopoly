package com.youngcapital.tineke.game.elements;

public class Card {
	private String name;
	private String explanation;
	private boolean canKeep;
	

	public Card(){
		// only needed to get a card from the deck and do multiple things with it.
		// will be filled by a card from the deck on a second line...
	}
	
	public Card(String name, String explanation){
		this.name=name;
		this.explanation=explanation;
		// Only some cards can be kept
		if(name.equals("OutJail")){
			canKeep = true;
		} else{
			canKeep = false;
		}
	}

	public boolean isCanKeep() {
		return canKeep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " with the explanation: " + explanation;
	}
	
	

}