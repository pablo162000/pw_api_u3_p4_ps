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
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;

	// GET
	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		// return
		// ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
		return this.estudianteService.consultarPorCedula(cedula);
	}

	// @GetMapping(path = "/{identificador}")
	// public Estudiante consultarPorId(@PathVariable Integer identificador) {

	// return this.estudianteService.buscarPorId(identificador);
	// }

	@PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
	// Request
	public void guardar(@RequestBody Estudiante estudiante) {

		this.estudianteService.guardar(estudiante);
	}

	@PostMapping(path = "/insertar", consumes = "application/xml", produces = MediaType.APPLICATION_JSON_VALUE)
	// Request
	public Estudiante guardar2(@RequestBody Estudiante estudiante) {

		// this.estudianteService.insertar2(estudiante);
		this.estudianteService.guardar(estudiante);
		return this.estudianteService.consultarPorCedula(estudiante.getCedula());

	}

	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}

	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		Estudiante estu1 = this.estudianteService.buscarPorId(identificador);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estu1);
	}

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);

	}

	@GetMapping
	public ResponseEntity<List<Estudiante>> buscarTodos() {

		List<Estudiante> lista = this.estudianteService.buscarTodos();

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detallemensjae", "Ciudadanos consultados exitosamente");
		cabeceras.add("valorAPI", "incalculable");
		return new ResponseEntity<>(lista, cabeceras, 228);

	}

	@GetMapping(path = "/provincia")
	public ResponseEntity<List<Estudiante>> consultarTodosPorProvincia(@RequestParam String provincia) {
		List<Estudiante> lista = this.estudianteService.consultarTodos(provincia);

		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detallemensjae", "Ciudadanos consultados exitosamente");
		cabeceras.add("valorAPI", "incalculable");
		return new ResponseEntity<>(lista, cabeceras, 228);
	}

	@GetMapping(path = "/hateoas")
	public ResponseEntity<List<EstudianteTO>> consultarTodos() {

		List<EstudianteTO> lista = this.estudianteService.buscarTodos1();

		for (EstudianteTO e : lista) {
			Link myLink = linkTo(methodOn(EstudianteControllerRestFul.class).buscarPorEstudiante(e.getCedula()))
					.withRel("materias");
			e.add(myLink);

		}

		return new ResponseEntity<>(lista, null, 200);

	}

	@GetMapping(path = "/{cedula}/materias")
	public ResponseEntity<List<MateriaTO>> buscarPorEstudiante(@PathVariable String cedula) {
		return null;
	}

	// http://localhost:8080/API/Matricula/estudiantes/buscar
}
