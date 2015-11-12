package com.youngcapital.tineke.game.elements;

public class Tile {
	private int index;
	private String name;
	private boolean taken = false;
	private int cost;
	private int[] rent = new int[6];
	private int mortgage;
	private int houses = 0;
	private int hotel = 0;
	private int costHouse;

	public Tile(int index, String name, int cost, int[] rent, int mortgage, int costHouse) {
		this.index = index;
		this.name = name;
		this.cost = cost;
		this.rent = rent;
		this.mortgage = mortgage;
		this.costHouse = costHouse;
	}

	@Override
	public String toString() {
		String toReturn = name + cost;
		return toReturn;
	}

	// do what is necessary on that tile..
	public void checkTile() {

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
			if(taken){
				// pay rent
				System.out.println("Pay rent");
			} else{
				// want to buy?
				System.out.println("Want to buy?");
			}
			break;
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int[] getRent() {
		return rent;
	}

	public void setRent(int[] rent) {
		this.rent = rent;
	}

	public int getMortgage() {
		return mortgage;
	}

	public void setMortgage(int mortgage) {
		this.mortgage = mortgage;
	}

	public int getHouses() {
		return houses;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getCostHouse() {
		return costHouse;
	}

	public void setCostHouse(int costHouse) {
		this.costHouse = costHouse;
	}

}
