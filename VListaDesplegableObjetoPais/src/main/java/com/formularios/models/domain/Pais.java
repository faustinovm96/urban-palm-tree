package com.formularios.models.domain;

import javax.validation.constraints.NotEmpty;

public class Pais {

	public Pais() {
		// TODO Auto-generated constructor stub
	}

	public Pais(Integer id, String codigo, String pais) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = pais;
	}
	
	private Integer id;
	
	@NotEmpty
	private String codigo;
	private String nombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setNombre(String pais) {
		this.nombre = pais;
	}

}
