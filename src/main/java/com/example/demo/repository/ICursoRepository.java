package com.example.demo.repository;

import com.example.demo.repository.model.Curso;

public interface ICursoRepository {
	
	public void guardar(Curso curso);
	
	public Curso buscar(Integer id);
	
	public void actualizar(Curso curso);
	
	
	public void borrar(Integer id);
	

}
