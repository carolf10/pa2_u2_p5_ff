package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	@Override
	public Estudiante seleccionarPorCedulaNombre(String cedula, String nombre) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> criteriaQuery = criteriaBuilder.createQuery(Estudiante.class);
		Root<Estudiante> myFrom = criteriaQuery.from(Estudiante.class);
		Predicate condicionFinal = null;
		if(cedula.startsWith("14")) {
			condicionFinal = criteriaBuilder.equal(myFrom.get("cedula"), cedula);
		} else if(cedula.startsWith("12")) {
			condicionFinal = criteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} 
		criteriaQuery.select(myFrom).where(condicionFinal);
		TypedQuery<Estudiante> query=this.entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}
	

}
