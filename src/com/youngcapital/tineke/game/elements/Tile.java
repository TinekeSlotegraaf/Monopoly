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
