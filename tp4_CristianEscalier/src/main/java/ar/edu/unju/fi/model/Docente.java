package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Docente {

	private Integer Legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;

	public Docente() {
	}

	public Docente(Integer legajo, String nombre, String apellido, String email, String telefono) {
		Legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getLegajo() {
		return Legajo;
	}

	public void setLegajo(Integer legajo) {
		Legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
