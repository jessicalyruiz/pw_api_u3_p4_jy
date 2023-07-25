package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Profesor;

public interface IProfesorRepo {

	public Profesor buscarCedula(String cedula);
	public void create(Profesor profesor);
	public Profesor read(Integer id);
	public void update(Profesor profesor);
	public void delete(Integer id);
	
	public void partialUpdate(String cedulaActual, String cedulaNueva);
	public List<Profesor> buscarTodos();
	
	public List<Profesor> buscarCategoria(String categoria);
}
