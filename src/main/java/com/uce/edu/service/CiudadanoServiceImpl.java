package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	
	@Autowired
	private ICiudadanoRepository iCiudadanoRepository;

	@Override
	public void guardar(Ciudadano ciudadano) {
		this.iCiudadanoRepository.insertar(ciudadano);

	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCiudadanoRepository.seleccionar(id);
	}

}
