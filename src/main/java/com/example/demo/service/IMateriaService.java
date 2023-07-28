package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.TO.MateriaTO;

public interface IMateriaService {

	public Materia buscarCodigo(String codigo);
	public void create(Materia materia);
	
	public Materia buscarId(Integer id);
	public void actualizar(Materia materia);
	public void eliminar(Integer id);
	
	public List<MateriaTO> buscarTodos();
	
	public MateriaTO buscarIDTO(Integer id);
	public List<MateriaTO> buscarPorCedula(String cedula) ;
}
