package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.ExpedienteAcademico;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IEstudianteService;
import com.uce.edu.service.IExpedienteAcademicoService;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IEmpleadoService empleadoService;
	@Autowired
	private IHabitacionService habitacionService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IAutorService autorService;
	@Autowired
	private IEstudianteService estudianteService;
	@Autowired
	private IExpedienteAcademicoService academicoService;
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Con la sentencia Typed Query");
		Empleado empleado = this.empleadoService.buscarPorCodigo("D01");
		System.out.println(empleado);
		
		Autor autor1 = this.autorService.buscarPorNombre("Pepito Teran");
		System.out.println(autor1);
		
		Habitacion habitacion1= this.habitacionService.buscarPorNumero("E1");
		System.out.println(habitacion1);
		
		Hotel hotel = this.hotelService.buscarPorNombre("Hilton Colon");
		System.out.println(hotel);
		
		Estudiante estudiante=this.estudianteService.buscarPorCedula("1236");
		System.out.println(estudiante);
		
		
		System.out.println("Con la sentencia Native Query");
		
		ExpedienteAcademico academico= this.academicoService.buscarPorCodigo("EA1");
		System.out.println(academico);
		
		Libro libro= this.iLibroService.buscarPorCodigo("L04");
		System.out.println(libro);
		
		Autor autor2 = this.autorService.buscarPorNacionalidad("Colombiano");
		System.out.println(autor2);
		
		Ciudadano ciudadano = this.ciudadanoService.buscarPorNombre("Maria");
		System.out.println(ciudadano);
		
		Habitacion habitacion2 = this.habitacionService.buscarPorClase("Normal");
		System.out.println(habitacion2);
		
	}

}
