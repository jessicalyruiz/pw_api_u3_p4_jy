package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Profesor;

public interface IProfesorService {

	public Profesor buscarCedula(String cedula);
	public void create(Profesor profesor);
	
	public Profesor buscarId(Integer id);
	
	public void update(Profesor profesor);
	public void delete(Integer id);
	
	public void partialUpdate(String cedulaActual, String cedulaNueva);
	public List<Profesor> buscarTodos();
	
	public List<Profesor> buscarCategoria(String categoria);
}
