package com.uce.edu.service;

import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
	public Empleado buscar (Integer id);
	public void guardar(Empleado empleado);
	public void actualizar (Empleado empleado);
	public void borrar (Integer id);
	public Empleado buscarPorCodigo(String codigo);
	public Empleado buscarPorCodigoDireccion(String codigo, String direccion);

}
