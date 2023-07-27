package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Estudiante;
import com.example.demo.service.to.EstudianteTO;

public interface IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	public List<Estudiante> buscarTodos();
	
	public List<Estudiante> consultarTodos(String provincia);

	
	public Estudiante buscarPorId(Integer id);

	public Estudiante insertar2(Estudiante  estudiante);

	
	public List<EstudianteTO> buscarTodos1();
}
