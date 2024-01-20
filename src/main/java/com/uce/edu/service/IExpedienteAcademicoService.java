package com.uce.edu.service;

import com.uce.edu.repository.modelo.ExpedienteAcademico;

public interface IExpedienteAcademicoService {
	public ExpedienteAcademico buscar(Integer id);
	public void guardar (ExpedienteAcademico autor);
	public void actualizar (ExpedienteAcademico autor);
	public void eliminar(Integer id);
	public ExpedienteAcademico buscarPorCodigo(String codigo);
}
