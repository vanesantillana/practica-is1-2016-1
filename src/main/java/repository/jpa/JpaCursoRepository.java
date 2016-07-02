package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import repository.CursoRepository;
import domain.Account;
import domain.Curso;

@Repository
public class JpaCursoRepository extends JpaBaseRepository<Curso, Long> implements
		CursoRepository {

	@Override
	public Curso findByCodigo(String codigo) {
		
		String jpaQuery = "SELECT a FROM Curso a WHERE a.codigo = :codigo";
		TypedQuery<Curso> query = entityManager.createQuery(jpaQuery, Curso.class);
		query.setParameter("codigo", codigo);
		return getFirstResult(query);
	}
	@Override
	public Collection<Curso> findByNombre(String nombre) {
		String jpaQuery = "SELECT a FROM Curso a  WHERE a.nombre like :nombre";
		TypedQuery<Curso> query = entityManager.createQuery(jpaQuery, Curso.class);
		query.setParameter("nombre","%" + nombre + "%" );
		return query.getResultList();
	}
}
