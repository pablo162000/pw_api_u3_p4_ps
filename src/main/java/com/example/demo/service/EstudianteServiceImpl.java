package com.example.demo.service;

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
		return estudianteService.seleccionarPorCedula(cedula);
	}

}
