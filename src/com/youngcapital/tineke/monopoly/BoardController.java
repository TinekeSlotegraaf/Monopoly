package com.youngcapital.tineke.monopoly;

import java.awt.Image;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	

	@RequestMapping(method=RequestMethod.GET)
	public void board(){
	}
	

}
