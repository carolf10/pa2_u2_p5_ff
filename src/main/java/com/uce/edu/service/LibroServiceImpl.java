package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public Libro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionar(id);
	}

	@Override
	public void guardar(Libro libro) {
		this.iLibroRepository.insertar(libro);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.iLibroRepository.eliminar(id);
		
	}

	@Override
	public void actualizar(Libro libro) {
		this.iLibroRepository.actualizar(libro);
		
	}

	@Override
	public void guardar(Libro2 libro) {
		this.iLibroRepository.insertar(libro);
		
	}

	@Override
	public Libro buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorNombre(nombre);
	}


}
