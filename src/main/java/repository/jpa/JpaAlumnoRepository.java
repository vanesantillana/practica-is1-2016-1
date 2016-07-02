package repository.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.AlumnoRepository;
import domain.Account;
import domain.Alumno;

@Repository
public class JpaAlumnoRepository extends JpaBaseRepository<Alumno, Long> implements
		AlumnoRepository {

	@Override
	public Alumno findByApellido(String alumno) {
		
		String jpaQuery = "SELECT a FROM Alumno a WHERE a.apellidoPaterno = :apellido";
		TypedQuery<Alumno> query = entityManager.createQuery(jpaQuery, Alumno.class);
		query.setParameter("apellido", alumno);
		return getFirstResult(query);
		
	}
}
