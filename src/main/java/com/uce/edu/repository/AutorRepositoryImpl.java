package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Autor;

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
public class AutorRepositoryImpl implements IAutorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Autor seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void insertar(Autor autor) {
		this.entityManager.persist(autor);
		
	}

	@Override
	public void eliminar(Integer id) {
		Autor autor= this.seleccionar(id);
		this.entityManager.remove(autor);
		
	}

	@Override
	public void actualizar(Autor autor) {
		this.entityManager.merge(autor);
		
	}

	@Override
	public Autor seleccionarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Autor> query= this.entityManager.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class);
		query.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

	@Override
	public Autor seleccionarPorNacionalidad(String nacionalidad) {
		// TODO Auto-generated method stub
		/*Query query= this.entityManager.createNativeQuery("SELECT a FROM autor a WHERE a.auto_nacionalidad = :nacionalidad", Autor.class);
		query.setParameter("nacionalidad", nacionalidad);
		return (Autor)query.getSingleResult();*/
		return null;
	}

	@Override
	public Autor seleccionarPorNombreNacionalidad(String nombre, String nacionalidad) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Autor> criteriaQuery = criteriaBuilder.createQuery(Autor.class);
		Root<Autor> myFrom = criteriaQuery.from(Autor.class);
		Predicate condicionNombre=criteriaBuilder.equal(myFrom.get("nombre"), nombre);
		Predicate condicionNacionalidad = criteriaBuilder.equal(myFrom.get("nacionalidad"), nacionalidad);
		Predicate condicionFinal = criteriaBuilder.and(condicionNacionalidad,condicionNombre);
		criteriaQuery.select(myFrom).where(condicionFinal);
		TypedQuery<Autor> query =this.entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}

}
