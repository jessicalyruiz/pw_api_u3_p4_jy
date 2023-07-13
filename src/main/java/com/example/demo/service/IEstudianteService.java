package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteService {

	public Estudiante buscarCedula(String cedula);
	public void create(Estudiante estudiante);
	
	public Estudiante buscarId(Integer id);
}
