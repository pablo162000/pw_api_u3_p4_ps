package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.model.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void guardar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);

	}

	@Override
	public Horario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

	@Override
	public Horario seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h WHERE h.codigo =:datoCodigo", Horario.class);
		
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub

		this.entityManager.merge(horario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h", Horario.class);
		
		return myQuery.getResultList();
	}

}
