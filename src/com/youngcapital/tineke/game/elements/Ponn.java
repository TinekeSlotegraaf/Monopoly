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
	
	public int move(int numberThrown){
		//  move the piece over the board.
		tile += numberThrown;
		int give = 0;
		if(tile>39){
			tile = tile%40;
			// and get 200 pounds for the player
			give = 200;
		}
		System.out.println("moved to " + tile);
		System.out.println("give money " + give);
		return give;
	}

	public int[] getPlaceOnBoard() {
		return placeOnBoard;
	}

	public void setPlaceOnBoard(int[] placeOnBoard) {
		this.placeOnBoard = placeOnBoard;
		System.out.println("The new coordinates are: " + placeOnBoard[0] + " " + placeOnBoard[1]);
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
