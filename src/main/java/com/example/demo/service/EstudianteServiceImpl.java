package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.model.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	
	@Autowired
	private IEstudianteRepository estudianteService;
	
	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteService.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteService.insertar(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteService.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteService.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteService.buscarTodos();
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteService.buscarPorId(id);
	}
	

}
