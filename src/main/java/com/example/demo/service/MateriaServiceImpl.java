package com.example.demo.service;

import java.util.List;

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

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizarMateria(materia);
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarPorId(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		 this.iMateriaRepository.borrar(id);
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarTodos();
	}

}
