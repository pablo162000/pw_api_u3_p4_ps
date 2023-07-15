package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Materia;

public interface IMateriaService {
	
	public Materia consularMateriaPorCodigo(String codigo);
	
	public void guardarMateria(Materia materia );
	
	public void actualizarMateria(Materia materia);
	
	public Materia buscarPorId(Integer id) ;
	public void borrar(Integer id);

	public List<Materia> buscarTodos();
	

}
