package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursoService;
import domain.Alumno;
import domain.Curso;

@Controller
public class CursoController {
	
	@Autowired
	CursoService cursoService;

	@RequestMapping(value = "/curso", method = RequestMethod.POST)
	String savecurso(@ModelAttribute Curso curso, ModelMap model) {
		System.out.println("savving: " + curso.getId());
		cursoService.save(curso);
		return showcurso(curso.getId(), model);
	}
	@RequestMapping(value = "/add-curso", method = RequestMethod.GET)
	String addNewcurso(@RequestParam(required = false) Long curso_id, ModelMap model) {
		Curso curso = curso_id == null ? new Curso() : cursoService.get(curso_id);
		System.err.println("mi id"+curso_id);
		model.addAttribute("curso", curso);
		return "add-curso";
	}

	

	@RequestMapping(value = "/search-curso", method = RequestMethod.GET)
	String searchNewalumnoIndex(String apellidoPaterno, ModelMap model) {
		return "search-curso";
	}
	@RequestMapping(value = "/search-curso", method = RequestMethod.POST)
	String searchNewalumno(String codigo, String opt,ModelMap model) {
		System.err.println(codigo);
		System.err.println(opt);
		short val;
		if(opt.equals("2"))
		{
			Curso curso=cursoService.buscaCodigo(codigo);
			model.addAttribute("curso", curso);
			val=1 ;
			model.addAttribute("val", val);
		}
		else
		{
			Collection<Curso> curso = cursoService.buscaByName(codigo);
			val=2 ;
			model.addAttribute("curso_list", curso);
			model.addAttribute("val", val);			
		}
		return "curso";
	}	
	
	
	
	@RequestMapping(value = "/curso", method = RequestMethod.GET)
	String showcurso(@RequestParam(required = false) Long curso_id, ModelMap model) {
		if (curso_id != null) {
			Curso curso = cursoService.get(curso_id);
			System.err.println("mi id"+curso.getId());
			model.addAttribute("curso", curso);
			return "curso";
		} else {
			Collection<Curso> people = cursoService.getAll();
			model.addAttribute("curso_list", people);
			return "cursos";
		}
	}

}
