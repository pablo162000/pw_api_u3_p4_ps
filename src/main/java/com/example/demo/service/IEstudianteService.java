package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);
	
	public List<Estudiante> buscarTodos();

}
