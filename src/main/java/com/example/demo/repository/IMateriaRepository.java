package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Materia;

public interface IMateriaRepository {
	
	
	
	

	
	public List<Materia> buscarPorCedulaEstudiante(String cedula);
	
	public List<Materia> bucarTodas();
	
	public Materia buscarPorId(Integer id);
	
	

}
