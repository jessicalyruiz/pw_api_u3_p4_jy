package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(path = "/{cedula}") 

	public ResponseEntity<Estudiante> consultarCedula(@PathVariable String cedula) { 

	return ResponseEntity.status(240).body(this.estudianteService.buscarCedula(cedula)); 

	} 

	@GetMapping 

	public ResponseEntity<List<Estudiante>> buscarTodos(){ 
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("detalle msj", "este es el msje , ciudadanos consultados con exito");
		cabeceras.add("valor ", "infinito");
	return new ResponseEntity<>(this.estudianteService.buscarTodos(),cabeceras, 228); 

	} 

	@PostMapping  //no hace falta el identificador.. solo sse inserta 1 registro 

	public void ingresarEstudiante(@RequestBody Estudiante estudiante) { 

	this.estudianteService.create(estudiante); 

	} 

	@PutMapping(path = "/{identif}") 

	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identif) { 

	estudiante.setId(identif); 

	//Estudiante estu=this.estudianteService.buscarId(identif); 

	this.estudianteService.update(estudiante); 

	} 

	@PatchMapping(path = "/{identificador}") 

	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) { 

	estudiante.setId(identificador); 

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

	@DeleteMapping(path = "/{id}") 

	public void borrar(@PathVariable Integer id) { 

	this.estudianteService.delete(id); 

	} 

	@GetMapping(path = "/buscarProvincia") 

	public List<Estudiante> buscarTodosProv(@RequestParam String provincia){ 

	return this.estudianteService.buscarProvincia(provincia); 

	} 
}
