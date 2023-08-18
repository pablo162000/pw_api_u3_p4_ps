package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICursoRepository;
import com.example.demo.repository.model.Curso;

@Service
public class CursoServiceImpl implements ICursoService {

	@Autowired
	private ICursoRepository cursoRepository;

	@Override
	public void guardar(Curso curso) {
		// TODO Auto-generated method stub

		this.cursoRepository.guardar(curso);
	}

	@Override
	public Curso buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.cursoRepository.buscar(id);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		this.cursoRepository.actualizar(curso);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.cursoRepository.borrar(id);
	}

}
