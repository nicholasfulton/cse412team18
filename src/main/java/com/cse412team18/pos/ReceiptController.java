package com.cse412team18.pos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	
	@RequestMapping("/receiptPage.html")
	public String pageForm() {
		//model.addAttribute("greeting", new Greeting());
		return "receiptPage";
	}
}
