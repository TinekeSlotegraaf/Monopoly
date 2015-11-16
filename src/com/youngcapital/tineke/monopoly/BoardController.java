package com.youngcapital.tineke.monopoly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.youngcapital.tineke.game.elements.Game;

@Controller
//@RequestMapping(value = "/board")
public class BoardController {
	
	private Game game;
	
	
	@RequestMapping(value = "/board", method=RequestMethod.GET)
	public String start(Model model){
		game = new Game();
		model.addAttribute("coordinatesPonn", game.getCoordinates());
		// kopieer hier de logica voor het starten van een spel
		// stop startcoordinaten in model
		return "board";
	}
	

	@RequestMapping(value = "/diceRoll")
	public String turn(Model model){
		// kopieer hier de logica voor het doen van de volgende zet
		int sum = game.turn();
		// stop coordinaten in model
		model.addAttribute("coordinatesPonn", game.getCoordinates());
		// stop uitkomst dice roll in model
		model.addAttribute("sum", sum);
		model.addAttribute("dice1", game.getRoll1());
		model.addAttribute("dice2", game.getRoll2());
		
		return "board";
	}
}
