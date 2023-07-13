package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteRepo {

	public Estudiante buscarCedula(String cedula);
	public void create(Estudiante estudiante);
	public Estudiante read(Integer id);
	public void update(Estudiante estudiante);
	public void delete(Integer id);
}
