package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;

@Service
public class LibroServiceImpl  implements ILibroService{
	
	@Autowired
	private ILibroRepository iLibroRepository;

	@Override
	public void guadar(Libro libro) {
		this.iLibroRepository.insertar(libro);
		
	}

}
