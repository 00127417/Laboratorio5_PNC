package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Column(name="nombre")
	@Size(min = 1,max = 50, message = "El nombre no debe superar los 50 caracteres ni ser menor a 1")
	private String Nombre;
	
	@Column(name="apellido")
	@Size(min = 1, max = 50, message = "El nombre no debe superar los 50 caracteres ni ser menor a 1")
	private String Apellido;
	
	@Column(name = "carne")
	@Size(min = 1, max = 10, message = "El nombre no debe superar los 10 caracteres ni ser menor a 1")
	private String Carne;
	
	@Column(name = "carrera")
	@Size(min = 1,max = 100, message = "El nombre no debe superar los 100 caracteres ni ser menor a 1")
	private String Carrera;
	
	public Estudiante() {
	}
	
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}
	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCarne() {
		return Carne;
	}

	public void setCarne(String carne) {
		Carne = carne;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}
	
	

}
