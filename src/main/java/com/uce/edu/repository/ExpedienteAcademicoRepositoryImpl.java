package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.ExpedienteAcademico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ExpedienteAcademicoRepositoryImpl implements IExpedienteAcademicoRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ExpedienteAcademico seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(ExpedienteAcademico.class, id);
	}

	@Override
	public void insertar(ExpedienteAcademico academico) {
		// TODO Auto-generated method stub
		this.entityManager.persist(academico);
	}

	@Override
	public void actualizar(ExpedienteAcademico academico) {
		// TODO Auto-generated method stub
		this.entityManager.merge(academico);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		ExpedienteAcademico academico=this.seleccionar(id);
		this.entityManager.remove(academico);
	}

	@Override
	public ExpedienteAcademico seleccionarPorCodigo(String codigo) {
		Query query= this.entityManager.createNativeQuery("SELECT ea FROM expediente_academico ea WHERE ea.exac_codigo = :codigo", ExpedienteAcademico.class);
		query.setParameter("codigo", codigo);
		return (ExpedienteAcademico)query.getSingleResult();
	}

}
