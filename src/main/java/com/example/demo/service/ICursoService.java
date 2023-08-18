package com.example.demo.service;

import com.example.demo.repository.model.Curso;

public interface ICursoService {

	public void guardar(Curso curso);

	public Curso buscar(Integer id);

	public void actualizar(Curso curso);

	public void borrar(Integer id);

}
