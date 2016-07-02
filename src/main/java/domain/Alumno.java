package domain;

import java.util.ArrayList;
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
public class Alumno implements BaseEntity<Long> {

	@Id
	@SequenceGenerator(name = "alumno_id_generator", sequenceName = "alumno_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_id_generator")
	private Long alumno_id;

	private String nombres;
	
	private String apellidoPaterno;

	private String apellidoMaterno;

	// uno a mucho
	@OneToMany(mappedBy = "alumno", fetch = FetchType.LAZY)
	private List<Matricula> origenmatricula;
	
	public void addMatricula(Matricula alumno) {
	     if (alumno != null) {
	        if (alumno == null) {
	        	origenmatricula = new  ArrayList<Matricula> ();          
	        }
	        origenmatricula.add(alumno);
	        alumno.setAlumno(this);
	     }
	  }
	
	@Override
	public Long getId() {
		return alumno_id;
	}

	@Override
	public void setId(Long id) {
		this.alumno_id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
