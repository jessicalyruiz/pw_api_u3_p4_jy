package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping(path = "/materias")
public class MateriaControllerRestFull {

	
	@Autowired
	IMateriaService materiaService;
	
	
	@GetMapping(path = "/buscar")
	public Materia buscar(String codigo) {
		return this.materiaService.buscarCodigo("111");
	}
	
	@PostMapping(path = "/ingresar")
	public void ingresar(@RequestBody Materia materia) {
		this.materiaService.create(materia);
	}
}
