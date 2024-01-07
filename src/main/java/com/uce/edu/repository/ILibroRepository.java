package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroRepository {
	public Libro seleccionar(Integer id);
	public void insertar (Libro libro);
	public void eliminar(Integer id);
	public void actualizar (Libro libro);

}
