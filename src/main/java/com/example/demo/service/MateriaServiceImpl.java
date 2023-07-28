package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepo;
import com.example.demo.repository.model.Materia;
import com.example.demo.service.TO.MateriaTO;

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

	@Override
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepo.update(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.materiaRepo.delete(id);
	}

	@Override
	public List<MateriaTO> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		List<Materia> lista=this.materiaRepo.buscarPorCedula(cedula);
		return lista.stream().map(m->this.convertirMateriaTO(m)).collect(Collectors.toList());
	}
	
	private MateriaTO convertirMateriaTO(Materia materia) {
		MateriaTO mate=new MateriaTO();
		mate.setCupo(materia.getCupo());
		mate.setId(materia.getId());
		mate.setNombre(materia.getNombre());
		return mate;
	}

	@Override
	public List<MateriaTO> buscarTodos() {
		// TODO Auto-generated method stub
		return this.materiaRepo.buscarTodos().stream().map(m->this.convertirMateriaTO(m)).collect(Collectors.toList());
	}

	@Override
	public MateriaTO buscarIDTO(Integer id) {
		// TODO Auto-generated method stub
		return this.convertirMateriaTO(this.buscarId(id));
	}
	


}
