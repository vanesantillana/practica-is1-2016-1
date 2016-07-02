package repository;

import domain.Alumno;

public interface AlumnoRepository extends BaseRepository<Alumno, Long> {
	public Alumno findByApellido(String alumno);
}
