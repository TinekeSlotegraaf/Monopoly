package com.youngcapital.tineke.monopoly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youngcapital.tineke.game.elements.*;

@Controller
// @RequestMapping(value = "/board")
public class BoardController {

	private Game game;
	private Player[] players = new Player[3];
	int index = 0;

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String start(Model model) {
		game = new Game();
		players = game.getPlayers();
		// Get the coordinates of the ponn, name, and amount of money of player
		// 1 and save them
		int[] coordinates1 = game.getCoordinates(players[0]);
		int xCoordinate1 = coordinates1[0];
		int yCoordinate1 = coordinates1[1];
		String name1 = game.getName(players[0]);
		int money1 = game.getMoney(players[0]);
		model.addAttribute("xCoordinate1", xCoordinate1);
		model.addAttribute("yCoordinate1", yCoordinate1);
		model.addAttribute("name1", name1);
		model.addAttribute("money1", money1);
	//	model.addAttribute("handCards1",game.getHandCardNames(players[0]));

		// Get coordinates of the ponn of player 2
		int[] coordinates2 = game.getCoordinates(players[1]);
		int xCoordinate2 = coordinates2[0];
		int yCoordinate2 = coordinates2[1];
		String name2 = game.getName(players[1]);
		int money2 = game.getMoney(players[1]);
		model.addAttribute("xCoordinate2", xCoordinate2);
		model.addAttribute("yCoordinate2", yCoordinate2);
		model.addAttribute("name2", name2);
		model.addAttribute("money2", money2);
	//	model.addAttribute("handCards2",game.getHandCardNames(players[1]));

		// Get coordinates of the ponn of player 3
		int[] coordinates3 = game.getCoordinates(players[2]);
		int xCoordinate3 = coordinates3[0];
		int yCoordinate3 = coordinates3[1];
		String name3 = game.getName(players[2]);
		int money3 = game.getMoney(players[2]);
		model.addAttribute("xCoordinate3", xCoordinate3);
		model.addAttribute("yCoordinate3", yCoordinate3);
		model.addAttribute("name3", name3);
		model.addAttribute("money3", money3);
//		model.addAttribute("handCards3",game.getHandCardNames(players[2]));
		
		//set value of dice to 1 so they can be shown
		model.addAttribute("dice1",1);
		model.addAttribute("dice2",1);
		
		// kopieer hier de logica voor het starten van een spel
		// stop startcoordinaten in model
		return "board";
	}

	@RequestMapping(value = "/diceRoll")
	public String turn(Model model) {
		//Haal uit game wie er aan de beurt is!!
		int who = game.getTurn();
		
		// kopieer hier de logica voor het doen van de volgende zet
		int sum = game.turn(players[who]);

		// stop uitkomst dice roll in model
		model.addAttribute("sum", sum);
		model.addAttribute("dice1", game.getRoll1());
		model.addAttribute("dice2", game.getRoll2());
		
		// The tile is checked during the turn, we want to save the Strings
		model.addAttribute("cardExplanation",game.getCardExplanation());
		model.addAttribute("tileExplanation",game.getTileExplanation());
		model.addAttribute("cardName", game.getNameCard());
		model.addAttribute("tileName", game.getTileName());
		model.addAttribute("costTile", game.getCostTile());

		// save the coordinates
		// Get the coordinates of the ponn, name, and amount of money per player
		int[] coordinates1 = game.getCoordinates(players[0]);
		int xCoordinate1 = coordinates1[0];
		int yCoordinate1 = coordinates1[1];
		String name1 = game.getName(players[0]);
		int money1 = game.getMoney(players[0]);
		model.addAttribute("xCoordinate1", xCoordinate1);
		model.addAttribute("yCoordinate1", yCoordinate1);
		model.addAttribute("name1", name1);
		model.addAttribute("money1", money1);
	//	model.addAttribute("handCards1",game.getHandCardNames(players[0]));

		// Get coordinates of the ponn of player 2
		int[] coordinates2 = game.getCoordinates(players[1]);
		int xCoordinate2 = coordinates2[0];
		int yCoordinate2 = coordinates2[1];
		String name2 = game.getName(players[1]);
		int money2 = game.getMoney(players[1]);
		model.addAttribute("xCoordinate2", xCoordinate2);
		model.addAttribute("yCoordinate2", yCoordinate2);
		model.addAttribute("name2", name2);
		model.addAttribute("money2", money2);
	//	model.addAttribute("handCards2",game.getHandCardNames(players[1]));

		// Get coordinates of the ponn of player 3
		int[] coordinates3 = game.getCoordinates(players[2]);
		int xCoordinate3 = coordinates3[0];
		int yCoordinate3 = coordinates3[1];
		String name3= game.getName(players[2]);
		int money3 = game.getMoney(players[2]);
		model.addAttribute("xCoordinate3", xCoordinate3);
		model.addAttribute("yCoordinate3", yCoordinate3);
		model.addAttribute("name3", name3);
		model.addAttribute("money3", money3);
	//	model.addAttribute("handCards3",game.getHandCardNames(players[2]));

		return "board";
	}
	
	@RequestMapping(params = {"yes", "!no"}, method = RequestMethod.POST)
	public String playerBoughtTile(Model model) {
	    // Logic to do when someone buys the Tile;
		
		return "board";
	}
	
	@RequestMapping(params = {"no", "!yes"}, method = RequestMethod.POST)
	public String playerDidNotBuyTile(Model model) {
	    // Do nothing when someone doesn't want to buy.
		return "board";
	}
	

}
