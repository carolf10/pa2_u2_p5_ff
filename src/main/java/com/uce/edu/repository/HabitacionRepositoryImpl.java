package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Habitacion;

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
public class HabitacionRepositoryImpl implements IHabitacionRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Habitacion seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void insertar(Habitacion habitacion) {
		this.entityManager.persist(habitacion);
		
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
	}

	@Override
	public void eliminar(Integer id) {
		Habitacion habitacion = this.seleccionar(id);
		this.entityManager.remove(habitacion);
		
	}

	@Override
	public Habitacion seleccionarPorNumero(String numero) {
		TypedQuery<Habitacion> query= this.entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.numero = :numero", Habitacion.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

	@Override
	public Habitacion seleccionarPorClase(String clase) {
		/*Query query=this.entityManager.createNativeQuery("SELECT * FROM habitacion h WHERE h.habi_clase = :clase",Habitacion.class);
		query.setParameter("clase", clase);
		return (Habitacion)query.getSingleResult();*/
		return null;
	}

	@Override
	public Habitacion seleccionarPorNumeroClase(String numero, String clase) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Habitacion> criteriaQuery = criteriaBuilder.createQuery(Habitacion.class);
		Root<Habitacion> myFrom = criteriaQuery.from(Habitacion.class);
		Predicate condicionFinal = null;
		Predicate condicionNumero = criteriaBuilder.equal(myFrom.get("numero"), numero);
		Predicate condicionClase = criteriaBuilder.equal(myFrom.get("clase"), clase);
		if(clase.startsWith("E")) {
			condicionFinal=criteriaBuilder.equal(myFrom.get("numero"), numero);
		}else if(clase.startsWith("N")){
			condicionFinal=criteriaBuilder.and(condicionNumero,condicionClase);
		}
		criteriaQuery.select(myFrom).where(condicionFinal);
		TypedQuery<Habitacion> query= this.entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();
	}

}
