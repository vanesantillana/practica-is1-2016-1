package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import repository.CursoRepository;
import domain.Curso;
import domain.Person;

@Service
public class CursoService {

	@Autowired
	CursoRepository cursoRepository;

	@Transactional
	public void save(Curso person) {
		if (person.getId() == null) {
			cursoRepository.persist(person);
		} else {
			cursoRepository.merge(person);
		}
	}

	public Curso get(Long id) {
		return cursoRepository.find(id);
	}

	public Collection<Curso> getAll() {
		return cursoRepository.findAll();
	}
	public Curso buscaCodigo(String codigo)
	{
		return cursoRepository.findByCodigo(codigo);
	}
	public Collection<Curso>  buscaByName(String codigo)
	{
		return cursoRepository.findByNombre(codigo);
	}
}
