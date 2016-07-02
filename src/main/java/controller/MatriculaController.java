package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Alumno;
import domain.Matricula;
import service.MatriculaService;

@Controller
public class MatriculaController {
	
	@Autowired
	MatriculaService matriculaService;

	@RequestMapping(value = "/add-matricula", method = RequestMethod.GET)
	String addNewMatricula(@RequestParam(required = false) Long Matricula_id, ModelMap model) {
		Matricula Matricula = Matricula_id == null ? new Matricula() : matriculaService.get(Matricula_id);
		System.err.println("mi id"+Matricula_id);
		model.addAttribute("matricula", Matricula);
		return "add-matricula";
	}

	

	@RequestMapping(value = "/search-matricula", method = RequestMethod.GET)
	String searchNewalumnoIndex(String apellidoPaterno, ModelMap model) {
		return "search-matricula";
	}

	
	
	@RequestMapping(value = "/matricula", method = RequestMethod.GET)
	String showMatricula(@RequestParam(required = false) Long Matricula_id, ModelMap model) {
		if (Matricula_id != null) {
			Matricula Matricula = matriculaService.get(Matricula_id);
			System.err.println("mi id"+Matricula.getId());
			model.addAttribute("matricula", Matricula);
			return "matricula";
		} else {
			Collection<Matricula> people = matriculaService.getAll();
			model.addAttribute("matricula_list", people);
			return "matriculas";
		}
	}

}
