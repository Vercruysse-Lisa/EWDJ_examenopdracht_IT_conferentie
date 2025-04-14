package com.examenopdracht_ITconferentie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Lokaal;
import jakarta.validation.Valid;
import repository.LokaalRepository;

@Controller
@RequestMapping("/lokaal")
public class LokaalController {
	
	@Autowired
	LokaalRepository lokaalRepository;
	
	@Autowired Validator lokaalValidator;
	
	@GetMapping
	public String lokaalForm(Model model) {
		model.addAttribute("lokaal", new Lokaal());
		return "lokaalForm";
	}
	
	@PostMapping
	public String AddLokaalForm(@Valid Lokaal lokaal, BindingResult result, Model model) {
		
		lokaalValidator.validate(lokaal, result);
		
		if (result.hasErrors()) {
			return "lokaalForm";
		}
		
		lokaalRepository.save(lokaal);
		return "conferentieOverzicht";
	}
}
