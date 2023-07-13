package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.model.Materia;
@Service
public class MateriaServiceImpl implements IMateriaService {

	
	
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public Materia consularMateriaPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarMateriaPorCodigo(codigo);
	}

	@Override
	public void guardarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertar(materia);
	}

}
