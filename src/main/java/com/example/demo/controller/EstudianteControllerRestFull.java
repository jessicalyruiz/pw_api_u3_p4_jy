package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFull {

	
	@Autowired
	IEstudianteService estudianteService;
	
	@GetMapping(path = "/buscar/{cedula}")
	public Estudiante consultarCedula(@PathVariable String cedula) {
		return this.estudianteService.buscarCedula(cedula);
		
	}
	
	@PostMapping(path = "/ingresar")
	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {
		this.estudianteService.create(estudiante);
	}
	
	@PutMapping(path = "/actualizar/{identif}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identif) {
		
		estudiante.setId(identif);
		//Estudiante estu=this.estudianteService.buscarId(identif);
		this.estudianteService.update(estudiante);
	}
	
	
	
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(@RequestBody Estudiante estudiante) {
		Integer identif=11;
		estudiante.setId(identif);
		
		
		/*
		///dos formas
		String cedula="230011506";
		Estudiante estu=this.estudianteService.buscarCedula(cedula);
		estu.setCedula(estudiante.getCedula());
		this.estudianteService.update(estudiante);	
		*/
		
		///
		this.estudianteService.partialUpdate("230011506", estudiante.getCedula());
		
	}
	
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.delete(id);
		
	}
	
	@GetMapping(path = "/buscar")
	public List<Estudiante> buscarTodos(){
		return this.estudianteService.buscarTodos();
	}
	
	@GetMapping(path = "/buscarProvincia")
	public List<Estudiante> buscarTodosProv(@RequestParam String provincia){
		return this.estudianteService.buscarProvincia(provincia);
	}
}
