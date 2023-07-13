package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.model.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepo materiaRepo;
	
	@Override
	public Materia buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscarCodigo(codigo);
	}

	@Override
	public void create(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepo.create(materia);
	}

	@Override
	public Materia buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.materiaRepo.read(id);
	}

}
