package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return this.estudianteService.buscarCedula(cedula);
		
	}
}
