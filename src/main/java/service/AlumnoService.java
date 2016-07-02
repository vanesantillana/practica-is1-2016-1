package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import repository.AlumnoRepository;


@Service
public class AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;

	@Transactional
	public void save(Alumno person) {
		if (person.getId() == null) {
			alumnoRepository.persist(person);
		} else {
			alumnoRepository.merge(person);
		}
	}

	public Alumno get(Long id) {
		return alumnoRepository.find(id);
	}

	public Collection<Alumno> getAll() {
		return alumnoRepository.findAll();
	}
	public Alumno buscaApellido(String alumno)
	{
		return alumnoRepository.findByApellido(alumno);
	}
}
