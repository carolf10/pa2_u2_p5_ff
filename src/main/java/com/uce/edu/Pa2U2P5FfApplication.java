package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IAlumnoService;
import com.uce.edu.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private IEstudianteService iEstudianteService;
	
	@Autowired
	private IAlumnoService iAlumnoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1. Metodo Guardar
		/*Estudiante estudiante = new Estudiante();
		estudiante.setNombre("janneth");
		estudiante.setApellido("abad");
		estudiante.setCedula("175334333");
		estudiante.setFechaNacimiento(LocalDateTime.of(2002, 02, 26, 3, 30));
		
		this.iEstudianteService.guardar(estudiante);
		
		this.iEstudianteService.buscar(4);
		System.out.println(estudiante);
		
		this.iEstudianteService.buscar(5);
		estudiante.setApellido("Estudiante Actualizado");
		this.iEstudianteService.actualizar(estudiante);
		
		this.iEstudianteService.borrar(1);*/
		
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Jorge");
		
		this.iAlumnoService.guardar(alumno);
		
		Alumno alumno2 = this.iAlumnoService.buscar(1);
		alumno2.setNombre("Nombre Actualizado");
		this.iAlumnoService.actualizar(alumno2);
		
		this.iAlumnoService.eliminar(2);
		
	}

}
