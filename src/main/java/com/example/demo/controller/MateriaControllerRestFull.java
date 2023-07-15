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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.model.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFull {

	@Autowired
	private IMateriaService materiaService;

	@GetMapping(path = "/buscar/{codigo}")
	public Materia consultarMateriaPorCodigo(@PathVariable String codigo) {
		return this.materiaService.consularMateriaPorCodigo(codigo);
	}

	@PostMapping(path = "/guardar")

	public void guardarMateria(@RequestBody Materia materia) {
		this.materiaService.guardarMateria(materia);

	}

	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizarMateria(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		this.materiaService.actualizarMateria(materia);

	}

	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizarParcialMateria(@RequestBody Materia materia, @PathVariable Integer identificador) {

		Materia mate1 = this.materiaService.buscarPorId(identificador);
		mate1.setCodigo(materia.getCodigo());
		this.materiaService.actualizarMateria(mate1);

	}

	// borrar
	@DeleteMapping(path = "/borrar/{id}")
	public void borrar(@PathVariable Integer id) {
		this.materiaService.borrar(id);
	}

	// buscar todos
	@GetMapping(path = "/buscarTodos")
	public List<Materia> buscarTodos(){
		
		
		
		return this.materiaService.buscarTodos();
		
	}
	
	// buscar todos
		@GetMapping(path = "/buscarPorProvincia")
		public List<Materia> buscarProvincia(){
			
			
			
			return this.materiaService.buscarTodos();
			
		}

}
