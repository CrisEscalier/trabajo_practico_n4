package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	
	private int codigo;
	private String nombre;
	private String curso;
	private short cantidadDeHoras;
	private Modalidad modalidad;
	@Autowired
	private Docente docente;
	@Autowired
	private Carrera carrera;
	
	/**
	 * Constructor vacio para la clase Materia
	 */
	public Materia() {
	}
	
	/**
	 * Contructor sobrecargado para la clase Materia
	 * @param codigo
	 * @param nombre
	 * @param curso
	 * @param cantidadDeHoras
	 * @param modalidad
	 * @param docente
	 * @param carrera
	 */
	public Materia(int codigo, String nombre, String curso, short cantidadDeHoras, Modalidad modalidad, Docente docente,
			Carrera carrera) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.cantidadDeHoras = cantidadDeHoras;
		this.modalidad = modalidad;
		this.docente = docente;
		this.carrera = carrera;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

	public short getCantidadDeHoras() {
		return cantidadDeHoras;
	}

	public void setCantidadDeHoras(short cantidadDeHoras) {
		this.cantidadDeHoras = cantidadDeHoras;
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
