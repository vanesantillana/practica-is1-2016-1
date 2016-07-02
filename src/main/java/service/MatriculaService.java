package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import domain.Matricula;
import repository.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	MatriculaRepository matriculaRepository;

	/*@Transactional
	public void save(Matricula person,Alumno alumno) {
		if (person.getId() == null) {
			
			matriculaRepository.persist(person);
		} else {
			matriculaRepository.merge(person,alumno);
		}
	}*/

	public Matricula get(Long id) {
		return matriculaRepository.find(id);
	}

	public Collection<Matricula> getAll() {
		return matriculaRepository.findAll();
	}

}
