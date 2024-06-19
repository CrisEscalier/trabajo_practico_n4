package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

//Carrera: código, nombre, cant. años, estado.
@Component
public class Carrera {
	
	private Integer codigo;
	private String nombre;
	private Short cantidadAnios;
	private Boolean estado;
	
	public Carrera() {
	}

	public Carrera(Integer codigo, String nombre, Short cantidadAnios, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidadAnios = cantidadAnios;
		this.estado = estado;
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

	public Short getCantidadAnios() {
		return cantidadAnios;
	}

	public void setCantidadAnios(Short cantidadAnios) {
		this.cantidadAnios = cantidadAnios;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
