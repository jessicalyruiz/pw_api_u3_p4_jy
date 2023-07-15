package com.example.demo.service;

import com.example.demo.repository.model.Materia;

public interface IMateriaService {

	public Materia buscarCodigo(String codigo);
	public void create(Materia materia);
	
	public Materia buscarId(Integer id);
	public void actualizar(Materia materia);
	public void eliminar(Integer id);
}
