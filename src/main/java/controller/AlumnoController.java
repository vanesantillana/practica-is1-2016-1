package controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.AlumnoService;
import service.CursoService;
import domain.Alumno;
import domain.Curso;

@Controller
public class AlumnoController {
	
	@Autowired
	AlumnoService alumnoService;

	@RequestMapping(value = "/alumno", method = RequestMethod.POST)
	String savealumno(@ModelAttribute Alumno curso, ModelMap model) {
		System.out.println("savving: " + curso.getId());
		alumnoService.save(curso);
		return showalumno(curso.getId(), model);
	}
	@RequestMapping(value = "/add-alumno", method = RequestMethod.GET)
	String addNewalumno(@RequestParam(required = false) Long alumno_id, ModelMap model) {
		Alumno curso = alumno_id == null ? new Alumno() : alumnoService.get(alumno_id);
		model.addAttribute("alumno", curso);
		return "add-alumno";
	}
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	String Menu(String apellidoPaterno, ModelMap model) {
		return "menu";
	}
	
	@RequestMapping(value = "/search-alumno", method = RequestMethod.GET)
	String searchNewalumnoIndex(String apellidoPaterno, ModelMap model) {
		return "search-alumno";
	}
	@RequestMapping(value = "/search-alumno", method = RequestMethod.POST)
	String searchNewalumno(String apellidoPaterno, ModelMap model) {
		System.err.println(apellidoPaterno);
		Alumno alumno= alumnoService.buscaApellido(apellidoPaterno);
		model.addAttribute("alumno", alumno);
		return "alumno";
	}	
	
	
	@RequestMapping(value = "/alumno", method = RequestMethod.GET)
	String showalumno(@RequestParam(required = false) Long alumno_id, ModelMap model) {
		if (alumno_id != null) {
			Alumno curso = alumnoService.get(alumno_id);
			System.err.println("apellido materno"+curso.getApellidoMaterno());
			model.addAttribute("alumno", curso);
			return "alumno";
		} else {
			Collection<Alumno> people = alumnoService.getAll();
			model.addAttribute("alumnos_list", people);
			return "alumnos";
		}
	}
}