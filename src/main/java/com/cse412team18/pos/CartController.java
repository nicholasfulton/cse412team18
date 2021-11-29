package com.cse412team18.pos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@GetMapping("/cart.html")
	public String cartForm() {
		//model.addAttribute("greeting", new Greeting());
		return "cart";
	}

	@PostMapping("/cart.html")
	public String toPayForm() {
		//model.addAttribute("greeting", greeting);
		return "paymentSection";
	}

}
