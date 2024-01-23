package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
	public Ciudadano seleccionar(Integer id);
	public void insertar(Ciudadano ciudadano);
	public void actualizar (Ciudadano ciudadano);
	public void eliminar(Integer id);
	public Empleado seleccionarPorCedula (String cedula);
	public Ciudadano seleccionarPorCedulaCiu(String cedula);
	public Ciudadano seleccionarPorNombre(String nombre);
	public Ciudadano seleccionarPorApellido(String apellido);
	public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
	public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
