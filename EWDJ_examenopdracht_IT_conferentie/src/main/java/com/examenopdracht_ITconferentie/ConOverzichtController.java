package com.examenopdracht_ITconferentie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConOverzichtController {
	
	@GetMapping("/conferentieOverzicht")
	public String conferentieOverzicht(Model model) {
		return "conferentieOverzicht";
	}
}
