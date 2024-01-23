package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	public Libro buscar(Integer id);
	public void guardar (Libro libro);
	public void guardar (Libro2 libro);
	public void eliminar(Integer id);
	public void actualizar (Libro libro);
	public Libro buscarPorNombre(String nombre);
	public Libro buscarPorTitulo(String titulo);
	public List<Libro> buscarPorFecha(LocalDateTime fecha);
	public List<Libro> buscarPorFechaT(LocalDateTime fecha);
	public Libro guadarPorTituloNamed(String titulo);
	public List<Libro> guardarPorFechaNamed(LocalDateTime fechaPublicacion);
	public Libro buscarPorCodigo(String codigo);
	public Libro buscarPorCodigoTitulo(String codigo, String titulo);

	
}
