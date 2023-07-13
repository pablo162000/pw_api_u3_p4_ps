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
@RequestMapping("/materias")
public class MateriaControllerRestFull {
	
	@Autowired
	private IMateriaService materiaService;
	@GetMapping(path = "/buscar")
	public Materia consultarMateriaPorCodigo() {
		String codigo = "1234";
		return this.materiaService.consularMateriaPorCodigo(codigo);
	}
	
	
	@PostMapping(path = "/guardar")
	
	public void guardarMateria(@RequestBody  Materia materia) {
		this.materiaService.guardarMateria(materia);
		
	}
	

}
