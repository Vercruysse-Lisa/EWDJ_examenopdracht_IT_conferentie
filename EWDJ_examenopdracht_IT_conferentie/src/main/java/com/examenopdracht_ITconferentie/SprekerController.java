package com.examenopdracht_ITconferentie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Spreker;
import jakarta.validation.Valid;
import service.SprekerService;

@Controller
@RequestMapping("/spreker")
public class SprekerController {
	
	@Autowired
	Validator sprekerValidator;
	
	@Autowired
	SprekerService sprekerService;
	
	@GetMapping
	public String sprekerForm(Model model) {
		model.addAttribute("spreker", new Spreker());
		return "sprekerForm";
	}
	
	@PostMapping
	public String addSprekerForm(@Valid Spreker spreker, BindingResult result, Model model) {
		
		sprekerValidator.validate(spreker, result);
		
		if(result.hasErrors()) {
			return "sprekerForm";
		}
		
		sprekerService.saveSpreker(spreker);
		return "sprekerForm";
	}
	
}
