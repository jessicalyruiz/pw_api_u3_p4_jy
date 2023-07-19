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

import com.example.demo.repository.model.Horario;
import com.example.demo.service.IHorarioService;

@RestController
@RequestMapping(path = "/horarios")
public class HorarioControllerRestFull {

	 

	@Autowired 

	IHorarioService horarioService; 

	
	//get
	@GetMapping(path = "/{codigo}") 

	public Horario consultarCodigo(@PathVariable String codigo) { 

	return this.horarioService.buscarCodigo(codigo); 

	} 

	@GetMapping 

	public List<Horario> buscarTodos(){ 

	return this.horarioService.buscarTodos(); 

	} 

	
	//**************************post
	@PostMapping  
	public void ingresarHorario(@RequestBody Horario horario) { 

	this.horarioService.create(horario); 

	} 

	@PutMapping(path = "/{identif}") 

	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identif) { 

	horario.setId(identif); 

	//Horario estu=this.horarioService.buscarId(identif); 

	this.horarioService.update(horario); 

	} 

	@PatchMapping(path = "/{identificador}") 

	public void actualizarParcial(@RequestBody Horario horario, @PathVariable Integer identificador) { 

	horario.setId(identificador); 

	Horario estu=this.horarioService.buscarId(identificador); 

	estu.setCodigo(horario.getCodigo()); 

	this.horarioService.update(horario);  
 
	}


	@DeleteMapping(path = "/{id}") 

	public void borrar(@PathVariable Integer id) { 

	this.horarioService.delete(id); 

	} 


	
}
