package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Curso;
import com.example.demo.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoControllerRestFul {

	@Autowired
	private ICursoService cursoService;

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.OK)
	private Curso consultarPorId(@PathVariable Integer id) {
		return this.cursoService.buscar(id);

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)

	private void guardar(@RequestBody Curso curso) {
		this.cursoService.guardar(curso);
	}

	@PutMapping(path = "/{id}")
	private void actualizar(@RequestBody Curso curso, @PathVariable Integer id) {
		curso.setId(id);
		this.cursoService.actualizar(curso);
	}

	@DeleteMapping(path = "/{id}")

	private void borrar(@PathVariable Integer id) {

		this.cursoService.borrar(id);
	}

}
