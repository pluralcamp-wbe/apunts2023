package com.pluralcamp.springweb.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {
	//inject via application.properties
	@Value("${welcome.email}")
	private String email;
	
	@GetMapping("/")
	public String mainWithParam() {
		return "index"; //view
	}

	//sempre que vulgui comunicar des del controlador
	//a la vista ho faré amb l'objecte de tipus Model
	@GetMapping("/subscription")
	public String mainWithParam(
			@RequestParam(name = "email", required = false, defaultValue = "") 
			String email, Model model) {
		if(email.equals("")) {
			model.addAttribute("email", this.email);
		}else {
			model.addAttribute("email", email);
		}
		return "subscription"; //view
	}
}
