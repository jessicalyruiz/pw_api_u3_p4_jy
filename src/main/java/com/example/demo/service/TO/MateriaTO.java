package com.example.demo.service.TO;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class MateriaTO extends RepresentationModel<MateriaTO> implements Serializable {

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
