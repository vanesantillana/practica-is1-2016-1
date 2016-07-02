package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Curso implements BaseEntity<Long> {
	
	@Id
	@SequenceGenerator(name = "curso_id_generator", sequenceName = "curso_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_id_generator")
	private Long curso_id;

	private String codigo;

	private String nombre;

	private Integer creditos;

	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
	private List<Curso> prerequisitos;

	
	  	
	@Override
	public Long getId() {
		return curso_id;
	}

	@Override
	public void setId(Long id) {
		this.curso_id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	public List<Curso> getPrerequisitos() {
		return prerequisitos;
	}

	public void setPrerequisitos(List<Curso> prerequisitos) {
		this.prerequisitos = prerequisitos;
	}

}
