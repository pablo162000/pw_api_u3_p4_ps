package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	
	//GET 
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		
		String cedula = "1234567";
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
}
