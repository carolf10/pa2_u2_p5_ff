package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Criteria API Query");
		
		System.out.println("Entidad Autor ---------------------------------------------------------");
		Autor autor = this.autorService.buscarPorNombreNacionalidad("Pepito Teran", "Ecuatoriano");
		System.out.println(autor);
		System.out.println("Entidad Empleado ---------------------------------------------------------");
		Empleado empleado = this.empleadoService.buscarPorCodigoDireccion("D01", "Alma Lojana");
		System.out.println(empleado);
		System.out.println("Entidad Estudiante ---------------------------------------------------------");
		Estudiante estudiante = this.estudianteService.buscarPorCedulaNombre("1452", "Fatima");
		System.out.println(estudiante);
		System.out.println("Entidad Habitacion ---------------------------------------------------------");
		Habitacion habitacion = this.habitacionService.buscarPorNumeroClase("N01", "Normal");
		System.out.println(habitacion);
		System.out.println("Entidad Libro ---------------------------------------------------------");
		Libro libro = this.iLibroService.buscarPorCodigoTitulo("L04", "Meridia");
		System.out.println(libro);
		

	}

}
