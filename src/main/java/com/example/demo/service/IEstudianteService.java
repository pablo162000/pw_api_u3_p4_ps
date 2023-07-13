package com.example.demo.service;

import com.example.demo.repository.model.Estudiante;

public interface IEstudianteService {
	public Estudiante consultarPorCedula(String cedula);

	public void guardar(Estudiante estudiante);
}
