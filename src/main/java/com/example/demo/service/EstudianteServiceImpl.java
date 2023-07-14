package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.model.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarCedula(cedula);
	}

	@Override
	public void create(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.create(estudiante);
	}

	@Override
	public Estudiante buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.read(id);
	}

	@Override
	public void update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.update(estudiante);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.delete(id);
	}

	@Override
	public void partialUpdate(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		this.estudianteRepo.partialUpdate(cedulaActual, cedulaNueva);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarTodos();
	}

	@Override
	public List<Estudiante> buscarProvincia(String provincia) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarProvincia(provincia);
	}

}
