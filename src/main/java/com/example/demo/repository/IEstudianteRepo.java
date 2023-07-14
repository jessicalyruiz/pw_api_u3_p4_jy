package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteRepo {

	public Estudiante buscarCedula(String cedula);
	public void create(Estudiante estudiante);
	public Estudiante read(Integer id);
	public void update(Estudiante estudiante);
	public void delete(Integer id);
	
	public void partialUpdate(String cedulaActual, String cedulaNueva);
	public List<Estudiante> buscarTodos();
	
	public List<Estudiante> buscarProvincia(String provincia);
}
