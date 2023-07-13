package com.example.demo.repository;

import com.example.demo.repository.model.Materia;

public interface IMateriaRepository {
	
	
	public Materia seleccionarMateriaPorCodigo(String codigo);
	
	
	public void insertar(Materia materia);

}
