package com.example.demo.service.TO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nombre;

	private String codigo;

	private Integer cupo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCupo() {
		return cupo;
	}

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

}
