package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

//Materia: código, nomre, curso, cantidad de horas, modalidad (virtual o presencial), docente (Docente), Carrera.
@Component
public class Materia {
	
	private Integer codigo;
	private String nombre;
	private String curso;
	private Short horas;
	private Modalidad modalidad;
	
	private Docente docente;
	
	private Carrera carrera;
	
	public Materia() {
	}

	public Materia(Integer codigo, String nombre, String curso, Short horas, Modalidad modalidad, Docente docente,
			Carrera carrera) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.horas = horas;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Short getHoras() {
		return horas;
	}

	public void setHoras(Short horas) {
		this.horas = horas;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

}
