package com.youngcapital.tineke.monopoly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Try {
	
	@RequestMapping("/try")
	public @ResponseBody String tried(){
		return "it worked!";
	}
}


