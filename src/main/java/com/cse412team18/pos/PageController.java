package com.cse412team18.pos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@GetMapping("/myStore")
	public String pageForm() {
		//model.addAttribute("greeting", new Greeting());
		return "page";
	}

	@PostMapping("/myStore")
	public String toCartForm() {
		//model.addAttribute("greeting", greeting);
		return "cart";
	}

}
