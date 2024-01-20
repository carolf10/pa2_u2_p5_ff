package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepository iEmpleadoRepository;

	@Override
	public void guardar(Empleado empleado) {
		this.iEmpleadoRepository.insertar(empleado);
		
	}

	@Override
	public Empleado buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iEmpleadoRepository.seleccionar(id);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.iEmpleadoRepository.actualizar(empleado);
		
	}

	@Override
	public void borrar(Integer id) {
		this.iEmpleadoRepository.eliminar(id);
		
	}

	@Override
	public Empleado buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iEmpleadoRepository.seleccionarPorCodigo(codigo);
	}


}
