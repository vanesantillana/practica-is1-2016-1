package domain;

import java.util.List;

public class Curso implements BaseEntity<Long> {
	private Long id;

	private String codigo;

	private String nombre;

	private Integer creditos;

	private List<Curso> prerequisitos;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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
