package repository.jpa;

import java.util.Collection;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import domain.Matricula;
import repository.MatriculaRepository;


@Repository
public class JpaMatriculaRepository extends JpaBaseRepository<Matricula, Long> implements
		MatriculaRepository {


}
