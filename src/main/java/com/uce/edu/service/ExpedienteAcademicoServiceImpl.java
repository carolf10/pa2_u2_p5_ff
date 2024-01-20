package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IExpedienteAcademicoRepository;
import com.uce.edu.repository.modelo.ExpedienteAcademico;
@Service
public class ExpedienteAcademicoServiceImpl implements IExpedienteAcademicoService {
	@Autowired
	private IExpedienteAcademicoRepository academicoRepository;

	@Override
	public ExpedienteAcademico buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.academicoRepository.seleccionar(id);
	}

	@Override
	public void guardar(ExpedienteAcademico academico) {
		// TODO Auto-generated method stub
		this.academicoRepository.insertar(academico);
	}

	@Override
	public void actualizar(ExpedienteAcademico academico) {
		// TODO Auto-generated method stub
		this.academicoRepository.actualizar(academico);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.eliminar(id);
	}

	@Override
	public ExpedienteAcademico buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.academicoRepository.seleccionarPorCodigo(codigo);
	}

}
