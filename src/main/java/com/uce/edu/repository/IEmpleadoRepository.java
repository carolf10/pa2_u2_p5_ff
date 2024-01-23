package com.uce.edu.repository;

import java.time.LocalDateTime;

import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
	public Empleado seleccionar (Integer id);
	public void insertar(Empleado empleado);
	public void actualizar (Empleado empleado);
	public void eliminar(Integer id);
	public Empleado seleccionarPorCodigo(String codigo);
	public Empleado seleccionarPorCodigoDireccion(String codigo, String direccion);

}
