package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Horario;

public interface IHorarioRepo {

	public Horario buscarCodigo(String codigo);
	public void create(Horario horario);
	public Horario read(Integer id);
	public void update(Horario horario);
	public void delete(Integer id);
	
	public void partialUpdate(String codigoActual, String codigoNueva);
	public List<Horario> buscarTodos();
	
}
