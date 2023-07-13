package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFull {

	
	@Autowired
	IEstudianteService estudianteService;
	
	@GetMapping(path = "/buscar")
	public Estudiante consultarCedula(String cedula) {
		return this.estudianteService.buscarCedula("2300116");
		
	}
	
	@PostMapping(path = "/ingresar")
	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {
		this.estudianteService.create(estudiante);
	}
	
	@PutMapping(path = "/actualizar")
	public void actualizar(Estudiante estudiante) {
		
	}
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial(Estudiante estudiante) {
		
	}
	
	@DeleteMapping(path = "/borrar")
	public void borrar(Integer id) {
		
	}
}
