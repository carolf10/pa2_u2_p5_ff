package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroService {
	public Libro buscar(Integer id);
	public void guardar (Libro libro);
	public void guardar (Libro2 libro);
	public void eliminar(Integer id);
	public void actualizar (Libro libro);
	public Libro buscarPorNombre(String nombre);
}
