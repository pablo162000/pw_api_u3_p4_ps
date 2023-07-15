package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.model.Estudiante;
import com.example.demo.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Materia seleccionarMateriaPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager
				.createQuery("SELECT m FROM Materia m WHERE m.codigo = :datoCodigo ", Materia.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);

	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	public Materia buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public List<Materia> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		List<Materia> materias = myQuery.getResultList();
		return materias;
	}

}
