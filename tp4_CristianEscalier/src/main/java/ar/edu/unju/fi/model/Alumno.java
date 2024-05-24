package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String eMail;
	private String telefono;
	private LocalDate fechaNacimiento;
	private String domicilio;
	private int libretaUniversitaria;
	
	public Alumno() {
	}

	public Alumno(int dni, String nombre, String apellido, String eMail, String telefono, LocalDate fechaNacimiento,
			String domicilio, int libretaUniversitaria) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eMail = eMail;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.libretaUniversitaria = libretaUniversitaria;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getLibretaUniversitaria() {
		return libretaUniversitaria;
	}

	public void setLibretaUniversitaria(int libretaUniversitaria) {
		this.libretaUniversitaria = libretaUniversitaria;
	}
	
	
	
	
}
