package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.model.Horario;

public interface IHorarioService {
	

	public void guardar(Horario horario);
	
	public Horario buscarPorId(Integer id);
	
	public Horario consultarPorCodigo(String codigo);
	
	
	public void actualizar(Horario horario);
	
	
	public void eliminar(Integer id);
	public List<Horario> buscarTodos();


}
