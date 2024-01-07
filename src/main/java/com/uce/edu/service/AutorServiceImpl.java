package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IAutorRepository;
import com.uce.edu.repository.modelo.Autor;

@Service
public class AutorServiceImpl implements IAutorService {
	@Autowired
	private IAutorRepository iAutorRepository;

	@Override
	public Autor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iAutorRepository.seleccionar(id);
	}

	@Override
	public void guardar(Autor autor) {
		this.iAutorRepository.insertar(autor);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.iAutorRepository.eliminar(id);
		
	}

	@Override
	public void actualizar(Autor autor) {
		this.iAutorRepository.actualizar(autor);
		
	}

	
}
