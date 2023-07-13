package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class PwApiU3P4JyApplication implements CommandLineRunner {

	
	@Autowired
	IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(PwApiU3P4JyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Estudiante estu=new Estudiante();
		estu.setApellido("yanez");
		estu.setNombre("jessica");
		estu.setCedula("23");
		estu.setFechaNacimiento(LocalDate.of(1992, 6, 24));
		
		//this.estudianteService.create(estu);
	}

}
