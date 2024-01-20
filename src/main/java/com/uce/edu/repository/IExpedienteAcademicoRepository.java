package com.uce.edu.repository;

import com.uce.edu.repository.modelo.ExpedienteAcademico;

public interface IExpedienteAcademicoRepository {
	public ExpedienteAcademico seleccionar(Integer id);
	public void insertar (ExpedienteAcademico autor);
	public void actualizar (ExpedienteAcademico autor);
	public void eliminar(Integer id);
	public ExpedienteAcademico seleccionarPorCodigo(String codigo);
}
