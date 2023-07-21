package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Materia> buscar(String codigo) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.buscarCodigo("111"));
	}
	
	@PostMapping(path = "/ingresar")
	public void ingresar(@RequestBody Materia materia) {
		this.materiaService.create(materia);
	}
	
	
	@PutMapping(path = "/actualizar/{codigo}")
	public void actualizar(@RequestBody Materia materia, @PathVariable String codigo) {
		materia.setCodigo(codigo);
		Materia materi=this.materiaService.buscarCodigo(codigo);
		materia.setId(materi.getId());
		this.materiaService.actualizar(materia);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.materiaService.eliminar(id);
	}
}
