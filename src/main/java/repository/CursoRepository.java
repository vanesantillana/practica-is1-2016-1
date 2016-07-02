package repository;

import java.util.Collection;

import domain.Curso;

public interface CursoRepository extends BaseRepository<Curso, Long> {
	public Curso findByCodigo(String codigo);
	public Collection<Curso> findByNombre(String nombre);
}
