package com.example.demo.service;

import com.example.demo.repository.model.Materia;

public interface IMateriaService {
	
	public Materia consularMateriaPorCodigo(String codigo);
	
	public void guardarMateria(Materia materia );
	

}
