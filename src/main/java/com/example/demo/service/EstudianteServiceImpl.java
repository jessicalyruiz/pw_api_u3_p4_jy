package com.example.demo.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.TO.EstudianteTO;

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
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public List<EstudianteTO> buscarTodosTO() {
		// TODO Auto-generated method stub
		List<Estudiante> lista=this.estudianteRepo.buscarTodos();

		return lista.stream().map(e->this.convertirTO(e)).collect(Collectors.toList());
	}
	
	
	private EstudianteTO convertirTO(Estudiante estudiante) {
		
		EstudianteTO estu=new EstudianteTO();
		estu.setApellido(estudiante.getApellido());
		estu.setCedula(estudiante.getCedula());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setId(estudiante.getId());
		estu.setNombre(estudiante.getNombre());
		estu.setProvincia(estudiante.getProvincia());
		return estu;
	}
 
}
