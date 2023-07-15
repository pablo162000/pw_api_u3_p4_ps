package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.model.Materia;

public interface IMateriaRepository {
	
	
	public Materia seleccionarMateriaPorCodigo(String codigo);
	
	
	public void insertar(Materia materia);
	
	public void actualizarMateria(Materia materia);

	
	public Materia buscarPorId(Integer id) ;
	
	public void borrar(Integer id);
	
	public List<Materia> buscarTodos();
	
	

}
