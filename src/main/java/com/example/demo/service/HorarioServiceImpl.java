package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHorarioRepo;
import com.example.demo.repository.model.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService{

	@Autowired
	private IHorarioRepo horarioRepo;
	
	@Override
	public Horario buscarCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.horarioRepo.buscarCodigo(codigo);
	}

	@Override
	public void create(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepo.create(horario);
	}

	@Override
	public Horario buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepo.read(id);
	}

	@Override
	public void update(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepo.update(horario);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepo.delete(id);
	}

	@Override
	public void partialUpdate(String codigoActual, String codigoNueva) {
		// TODO Auto-generated method stub
		this.horarioRepo.partialUpdate(codigoActual, codigoNueva);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		return this.horarioRepo.buscarTodos();
	}

	
}
