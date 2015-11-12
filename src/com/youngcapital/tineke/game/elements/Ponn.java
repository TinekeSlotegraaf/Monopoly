package com.youngcapital.tineke.game.elements;


public class Ponn {
	private int[] placeOnBoard = {0,0};
	private int tile = 0;
	private String name;
	private String imageReference;
	
	public Ponn(String reference, String name){
		imageReference = reference;
		this.name = name;
	}
	
	public void move(int numberThrown){
		//  move the piece over the board.
		tile += numberThrown;
		if(tile>39){
			tile = tile%40;
			// and get 200 pounds for the player...
		}
		System.out.println("moved to " + tile);
	}

	public int[] getPlaceOnBoard() {
		return placeOnBoard;
	}

	public void setPlaceOnBoard(int[] placeOnBoard) {
		this.placeOnBoard = placeOnBoard;
	}

	public int getTile() {
		return tile;
	}

	public void setTile(int tile) {
		this.tile = tile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageReference() {
		return imageReference;
	}

	public void setImageReference(String imageReference) {
		this.imageReference = imageReference;
	}

}
