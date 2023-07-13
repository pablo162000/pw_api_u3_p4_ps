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
import com.example.demo.repository.model.Materia;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	
	
	// GET
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {

		String cedula = "1724157688";
		return this.estudianteService.consultarPorCedula(cedula);
	}

	@PostMapping(path = "/guardar")
	//Request
	public void guardar(@RequestBody Estudiante estudiante) {

		this.estudianteService.guardar(estudiante);
	}
	
	
	

	@PutMapping(path = "/actualizar")
	public void actualizar() {

	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {

	}
	@DeleteMapping(path = "/borrar")
	public void borrar() {
		
	}

	// http://localhost:8080/API/Matricula/estudiantes/buscar
}
