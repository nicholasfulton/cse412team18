package com.cse412team18.pos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {
	
	@GetMapping("/paymentSection.html")
	public String payForm() {
		//model.addAttribute("greeting", new Greeting());
		return "paymentSection";
	}

	@PostMapping("/paymentSection.html")
	public String toReceiptForm() {
		//model.addAttribute("greeting", greeting);
		return "receiptPage";
	}

}
