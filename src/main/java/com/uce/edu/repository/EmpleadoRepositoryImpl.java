package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		this.entityManager.persist(empleado);

	}

	@Override
	public Empleado seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Empleado.class, id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.entityManager.merge(empleado);
		
	}

	@Override
	public void eliminar(Integer id) {
		Empleado empleado= this.seleccionar(id);
		this.entityManager.remove(empleado);
		
	}

	@Override
	public Empleado seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Empleado> query= this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.codigo = :codigo", Empleado.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

}
