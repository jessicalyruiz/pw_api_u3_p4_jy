package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Profesor;
import com.example.demo.service.IProfesorService;

@RestController
@RequestMapping(path = "/profesores")
@CrossOrigin
public class ProfesorControllerRestFull {

	 

	@Autowired 

	IProfesorService profesorService; 

	//@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE) 
	@GetMapping(path = "/{cedula}", produces = "application/xml")
	public Profesor consultarCedula(@PathVariable String cedula) { 
	return this.profesorService.buscarCedula(cedula);

	} 

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Profesor>> buscarTodos(){ 
		HttpHeaders cabeceras=new HttpHeaders();
		cabeceras.add("detalle msj", "este es el msje , ciudadanos consultados con exito");
		cabeceras.add("valor ", "infinito");
	return new ResponseEntity<>(this.profesorService.buscarTodos(),cabeceras, 228); 

	} 

	@PostMapping(consumes = "application/json")  //no hace falta el identificador.. solo sse inserta 1 registro 

	public void ingresarProfesor(@RequestBody Profesor profesor) { 

	this.profesorService.create(profesor); 

	} 
	
	
	@PostMapping(path =  "/io", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)  //no hace falta el identificador.. solo sse inserta 1 registro 

	public Profesor ingresarProfesorConsumesProd(@RequestBody Profesor profesor) { 

	this.profesorService.create(profesor); 
	System.out.println("***************"+profesor.getCedula());
	
	return profesor;
		
	}
	
	
	
	

	@PutMapping(path = "/{identif}", consumes = MediaType.APPLICATION_JSON_VALUE) 

	public void actualizar(@RequestBody Profesor profesor, @PathVariable Integer identif) { 

	profesor.setId(identif); 

	this.profesorService.update(profesor); 

	} 

	@PatchMapping(path = "/{identificador}", consumes = MediaType.APPLICATION_JSON_VALUE) 

	public void actualizarParcial(@RequestBody Profesor profesor, @PathVariable Integer identificador) { 

	profesor.setId(identificador); 
	Profesor prof=this.profesorService.buscarId(identificador);

	this.profesorService.partialUpdate(prof.getCedula(), profesor.getCedula()); 

	} 

	@DeleteMapping(path = "/{id}") 

	public void borrar(@PathVariable Integer id) { 

	this.profesorService.delete(id); 

	} 

	@GetMapping(path = "/buscarCat") 

	public List<Profesor> buscarTodosCat(@RequestParam String categoria){ 

	return this.profesorService.buscarCategoria(categoria); 

	} 
}
