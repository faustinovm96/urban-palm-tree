package com.formularios.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.formularios.validations.CedulaRegex;
import com.formularios.validations.Requerido;

public class Empleado {

	// @NotEmpty
	// @Pattern(regexp = "[0-9]{1}[.][\\d]{3}[.][\\d]{3}")
	@CedulaRegex
	private String cedula;

	// @NotEmpty
	private String nombre;

	@NotEmpty
	@Requerido
	private String direccion;

	// @Size(min = 3, max = 9) //Especfica el minimo o maximo
	@NotEmpty
	private String telefono;

	@Max(10)
	@Min(6)
	@NotNull
	private Integer cuenta;

	@Email // valida el formato de un email
	// @NotEmpty //ÉSte era el error aplique la anotacion no empty a un campo que
	// nunca rellene y nunca hice aparecer
	private String email;

	@NotNull
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	// @Past //Pasado
	// @PastOrPresent //Pasado o Presente
	// @Future //Futuro
	// @FutureOrPresent //Futuro o presente
	private Date fecha;

	//@NotEmpty
	//@Valid
	@NotNull
	private Pais pais;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
