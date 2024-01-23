package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

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

	@Override
	public List<Libro> buscarPorFecha(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaPublicacion(fecha);
	}

	@Override
	public Libro buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTitulo(titulo);
	}

	@Override
	public List<Libro> buscarPorFechaT(LocalDateTime fecha) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFecha(fecha);
	}

	@Override
	public Libro guadarPorTituloNamed(String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorTituloNamed(titulo);
	}

	@Override
	public List<Libro> guardarPorFechaNamed(LocalDateTime fechaPublicacion) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorFechaNamed(fechaPublicacion);
	}

	@Override
	public Libro buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorCodigo(codigo);
	}

	@Override
	public Libro buscarPorCodigoTitulo(String codigo, String titulo) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.seleccionarPorCodigoTitulo(codigo, titulo);
	}


}
