package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Curso;

@Transactional
@Repository
public class CursoRepositoryImpl implements ICursoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardar(Curso curso) {
		// TODO Auto-generated method stub
		this.entityManager.persist(curso);
	}

	@Override
	public Curso buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Curso.class, id);
	}

	@Override
	public void actualizar(Curso curso) {
		// TODO Auto-generated method stub
		this.entityManager.merge(curso);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
	
		this.entityManager.remove(this.buscar(id));
	}

	
}
