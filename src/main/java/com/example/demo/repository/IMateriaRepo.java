package com.example.demo.repository;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;

public interface IMateriaRepo {

	public Materia buscarCodigo(String codigo);
	public void create(Materia materia);
	public Materia read(Integer id);
	public void update(Materia materia);
	public void delete(Integer id);
}
