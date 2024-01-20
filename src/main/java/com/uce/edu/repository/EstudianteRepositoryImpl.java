package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Estudiante seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		Estudiante estu = this.seleccionar(id);
		this.entityManager.remove(estu);
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante> query= this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}
	

}
