package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@RequestMapping("/sumar")
	String suma(ModelMap model, @RequestParam Integer a, @RequestParam Integer b) {
		model.addAttribute("resultado", a + b);
		return "calc";
	}

	@RequestMapping("/restar")
	String resta(ModelMap model, @RequestParam Integer a, @RequestParam Integer b) {
		model.addAttribute("resultado", a - b);
		return "calc";
	}

	@RequestMapping("/multiplicar")
	String mult(@RequestParam Integer a, @RequestParam Integer b) {
		return "a*b=" + (a*b);
	}

}
