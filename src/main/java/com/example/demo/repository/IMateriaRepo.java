package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;

public interface IMateriaRepo {

	public Materia buscarCodigo(String codigo);
	public void create(Materia materia);
	public Materia read(Integer id);
	public void update(Materia materia);
	public void delete(Integer id);
	public List<Materia> buscarTodos();
	
	public List<Materia> buscarPorCedula(String cedula);
}
