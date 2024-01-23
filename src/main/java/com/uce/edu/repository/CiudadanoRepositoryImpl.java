package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano ciudadano) {
		this.entityManager.persist(ciudadano);

	}

	@Override
	public Ciudadano seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void actualizar(Ciudadano ciudadano) {
		this.entityManager.merge(ciudadano);

	}

	@Override
	public void eliminar(Integer id) {
		Ciudadano ciudadano = this.seleccionar(id);
		this.entityManager.remove(ciudadano);

	}

	@Override
	public Empleado seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> myQuery = this.entityManager
				.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula = :cedula", Empleado.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorCedulaCiu(String cedula) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula",
				Ciudadano.class);
		query.setParameter("cedula", cedula);
		return (Ciudadano) query.getSingleResult();
	}

	@Override
	public Ciudadano seleccionarPorNombre(String nombre) {
		/*
		 * Query query=this.entityManager.
		 * createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_nombre = :nombre"
		 * ,Ciudadano.class); query.setParameter("nombre", nombre); return
		 * (Ciudadano)query.getSingleResult();
		 */
		return null;
	}

	@Override
	public Ciudadano seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// Paso 0. Creamos una instancia de la intefaz CriteriaBuider a partit de un EM
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

		// Paso 1. Determinamos el tipo de retorno que va ha tener mi consulta
		CriteriaQuery<Ciudadano> criteriaQuery = criteriaBuilder.createQuery(Ciudadano.class);

		// Paso 2. Consultar el SQL
		// Paso 2.1 Determinamos el from (Root)
		// Nota: no necesariamente el from es igual al tipo de reotrno
		Root<Ciudadano> myFrom = criteriaQuery.from(Ciudadano.class); // FROM ciudadano

		// Paso 2.2 Construir las condiciones (WHERE) del sql
		// Nota: En criteria API Query las condiciones se las conoce como "predicate"
		Predicate condicionApellido = criteriaBuilder.equal(myFrom.get("apellido"), apellido);

		// Paso 3. Construimos el SQL final
		criteriaQuery.select(myFrom).where(condicionApellido);

		// Paso 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> query = this.entityManager.createQuery(criteriaQuery);

		return query.getSingleResult();
	}

	// Funcionalidad: 1. cuando sea el ciudadano de Pinchincha busque por nombre
	// 2. cuando sea de cotopaxi lo busque por apellido
	// 3. cuando no sea ni de cotopaxi ni pichicha lo busque por cedula
	@Override
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// Paso 0. Creamos una instancia de la intefaz CriteriaBuider a partit de un EM
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

		// Paso 1. Determinamos el tipo de retorno que va ha tener mi consulta
		CriteriaQuery<Ciudadano> criteriaQuery = criteriaBuilder.createQuery(Ciudadano.class);
		
		// Paso 2. Consultar el SQL
		// Paso 2.1 Determinamos el from (Root)
		Root<Ciudadano> myFrom = criteriaQuery.from(Ciudadano.class);
		
		// Paso 2.2 Construir las condiciones (WHERE) del sql
		Predicate codicionGenerica= null;
		if(cedula.startsWith("17")) {
			codicionGenerica = criteriaBuilder.equal(myFrom.get("nombre"), nombre);
		} else if(cedula.startsWith("05")) {
			codicionGenerica = criteriaBuilder.equal(myFrom.get("apellido"), apellido);
		} else {
			codicionGenerica = criteriaBuilder.equal(myFrom.get("cedula"), cedula);
		}
		
		// Paso 3. Construimos el SQL final
		criteriaQuery.select(myFrom).where(codicionGenerica);
		
		// Paso 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> query = this.entityManager.createQuery(criteriaQuery);

		return query.getSingleResult();
	}
	
	@Override
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		// Paso 0. Creamos una instancia de la intefaz CriteriaBuider a partit de un EM
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();

		// Paso 1. Determinamos el tipo de retorno que va ha tener mi consulta
		CriteriaQuery<Ciudadano> criteriaQuery = criteriaBuilder.createQuery(Ciudadano.class);
		
		// Paso 2. Consultar el SQL
		// Paso 2.1 Determinamos el from (Root)
		Root<Ciudadano> myFrom = criteriaQuery.from(Ciudadano.class);
		
		// Paso 2.2 Construir las condiciones (WHERE) del sql incluyendo el uso de las condiciones and y or
		Predicate condicionTotal= null;
		Predicate codicionNombre= criteriaBuilder.equal(myFrom.get("nombre"), nombre);
		Predicate condicionApellido= criteriaBuilder.equal(myFrom.get("apellido"), apellido);
		
		if(cedula.startsWith("17")) {
			condicionTotal = criteriaBuilder.or(codicionNombre,condicionApellido);
		} else if(cedula.startsWith("05")) {
			condicionTotal = criteriaBuilder.and(codicionNombre,condicionApellido);
		} 
		
		// Paso 3. Construimos el SQL final
		criteriaQuery.select(myFrom).where(condicionTotal);
		
		// Paso 4. Ejecutamos la consulta con un typedQuery
		TypedQuery<Ciudadano> query = this.entityManager.createQuery(criteriaQuery);

		return query.getSingleResult();
	}

}
