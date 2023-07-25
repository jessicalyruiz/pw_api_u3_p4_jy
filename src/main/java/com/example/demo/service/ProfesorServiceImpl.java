package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IProfesorRepo;
import com.example.demo.repository.model.Profesor;

@Service
public class ProfesorServiceImpl implements IProfesorService{

	@Autowired
	private IProfesorRepo profesorRepo;
	
	@Override
	public Profesor buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.profesorRepo.buscarCedula(cedula);
	}

	@Override
	public void create(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepo.create(profesor);
	}

	@Override
	public Profesor buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.profesorRepo.read(id);
	}

	@Override
	public void update(Profesor profesor) {
		// TODO Auto-generated method stub
		this.profesorRepo.update(profesor);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.profesorRepo.delete(id);
	}

	@Override
	public void partialUpdate(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		this.profesorRepo.partialUpdate(cedulaActual, cedulaNueva);
	}

	@Override
	public List<Profesor> buscarTodos() {
		// TODO Auto-generated method stub
		return this.profesorRepo.buscarTodos();
	}

	@Override
	public List<Profesor> buscarCategoria(String categoria) {
		// TODO Auto-generated method stub
		return this.profesorRepo.buscarCategoria(categoria);
	}

}
