package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;
import com.example.demo.service.TO.EstudianteTO;
import com.example.demo.service.TO.MateriaTO;

@RestController
@RequestMapping(path = "/estudiantes")
public class EstudianteControllerRestFull {

	@Autowired

	IEstudianteService estudianteService;
	
	@Autowired 
	IMateriaService materiaService;

	// @GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/{cedula}", produces = "application/xml")
	@ResponseStatus(code = HttpStatus.CONFLICT) // estos prefereible usar en los 300
	public Estudiante consultarCedula(@PathVariable String cedula) {

		return this.estudianteService.buscarCedula(cedula);

	}

	@GetMapping

	public ResponseEntity<List<Estudiante>> buscarTodos() {
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalle msj", "este es el msje , ciudadanos consultados con exito");
		cabeceras.add("valor ", "infinito");
		return new ResponseEntity<>(this.estudianteService.buscarTodos(), cabeceras, 228);

	}

	// ********************************* HATEOAS
	@GetMapping (path = "/hateoas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EstudianteTO>> buscarTodosHateoas(){ 
		
		//EstudianteTO est=null;
		
		List<EstudianteTO>lista= this.estudianteService.buscarTodosTO();
		for (EstudianteTO estudianteTO : lista) {
			Link myLink=linkTo(methodOn(EstudianteControllerRestFull.class).buscarPorEstudiante(estudianteTO.getCedula())).withRel("materias");
			estudianteTO.add(myLink);
		}
		
		
		
		return new ResponseEntity<>(lista, null,200);	}

	@GetMapping(path = "/{cedula}/materias",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MateriaTO>>  buscarPorEstudiante(@PathVariable String cedula){
		return new ResponseEntity<>(this.materiaService.buscarPorCedula(cedula),null,200);
	}

	@PostMapping(consumes = "application/json") // no hace falta el identificador.. solo sse inserta 1 registro

	public void ingresarEstudiante(@RequestBody Estudiante estudiante) {

		this.estudianteService.create(estudiante);

	}

	@PostMapping(path = "/conP", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE) // no
																															// hace
																															// falta
																															// el
																															// identificador..
																															// solo
																															// sse
																															// inserta
																															// 1
																															// registro

	public Estudiante ingresarEstudianteConsumesProd(@RequestBody Estudiante estudiante) {

		this.estudianteService.create(estudiante);

		return this.estudianteService.buscarCedula(estudiante.getCedula());

	}

	@PutMapping(path = "/{identif}")

	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identif) {

		estudiante.setId(identif);

		// Estudiante estu=this.estudianteService.buscarId(identif);

		this.estudianteService.update(estudiante);

	}

	@PatchMapping(path = "/{identificador}")

	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {

		estudiante.setId(identificador);

		/*
		 * 
		 * ///dos formas
		 * 
		 * String cedula="230011506";
		 * 
		 * Estudiante estu=this.estudianteService.buscarCedula(cedula);
		 * 
		 * estu.setCedula(estudiante.getCedula());
		 * 
		 * this.estudianteService.update(estudiante);
		 * 
		 */

		///

		this.estudianteService.partialUpdate("230011506", estudiante.getCedula());

	}

	@DeleteMapping(path = "/{id}")

	public void borrar(@PathVariable Integer id) {

		this.estudianteService.delete(id);

	}

	@GetMapping(path = "/buscarProvincia")

	public List<Estudiante> buscarTodosProv(@RequestParam String provincia) {

		return this.estudianteService.buscarProvincia(provincia);

	}
}
