package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;

@Service
public class HabitacionServiceImpl implements IHabitacionService {
	
	@Autowired
	private IHabitacionRepository iHabitacionRepository;

	@Override
	public Habitacion buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionar(id);
	}

	@Override
	public void guardar(Habitacion habitacion) {
		this.iHabitacionRepository.insertar(habitacion);

	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.iHabitacionRepository.actualizar(habitacion);

	}

	@Override
	public void eliminar(Integer id) {
		this.iHabitacionRepository.eliminar(id);

	}

	@Override
	public Habitacion buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionarPorNumero(numero);
	}

	@Override
	public Habitacion buscarPorClase(String clase) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionarPorClase(clase);
	}

	@Override
	public Habitacion buscarPorNumeroClase(String numero, String clase) {
		// TODO Auto-generated method stub
		return this.iHabitacionRepository.seleccionarPorNumeroClase(numero, clase);
	}

}
