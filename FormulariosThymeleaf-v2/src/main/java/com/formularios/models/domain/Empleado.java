package com.formularios.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Empleado {

	@NotEmpty
	@Pattern(regexp = "[0-9]{1}[.][\\d]{3}[.][\\d]{3}")
	private String cedula;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String direccion;

	//@Size(min = 3, max = 9) //Especfica el minimo o maximo
	@NotEmpty
	private String telefono;
	
	//@Email //valida el formato de un email
	//@NotEmpty //ÉSte era el error aplique la anotacion no empty a un campo que nunca rellene y nunca hice aparecer
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
