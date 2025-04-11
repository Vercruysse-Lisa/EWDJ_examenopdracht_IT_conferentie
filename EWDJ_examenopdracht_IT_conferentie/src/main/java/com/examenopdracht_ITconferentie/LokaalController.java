package com.examenopdracht_ITconferentie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Lokaal;

@Controller
@RequestMapping("/lokaal")
public class LokaalController {
	
	@GetMapping
	public String lokaalForm(Model model) {
		model.addAttribute("lokaal", new Lokaal());
		return "lokaalForm";
	}
	
	@PostMapping
	public String AddLokaalForm(Model model) {
		return "conferentieOverzicht";
	}
}
