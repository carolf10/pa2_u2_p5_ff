package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*Ciudadano ciudadano= new Ciudadano();
		ciudadano.setNombre("Fatima");
		ciudadano.setApellido("Fiallos");
		
		Ciudadano ciud2= this.iCiudadanoService.buscar(1);
		
		Empleado empleado = new Empleado();
		empleado.setFechaIngreso(LocalDateTime.now());
		empleado.setSalario(new BigDecimal(450));
		empleado.setCiudadano(ciud2);
		//this.iEmpleadoService.guardar(empleado);
		
		Ciudadano ciud = new Ciudadano();
		ciud.setNombre("Maria");
		ciud.setApellido("Checa");
		//this.iCiudadanoService.guardar(ciud);
		
		Empleado empl = new Empleado();
		empl.setFechaIngreso(LocalDateTime.now());
		empl.setSalario(new BigDecimal(456));
		empl.setCiudadano(ciud);
		
		this.iEmpleadoService.borrar(5);
		
		Ciudadano ciud3 = this.iCiudadanoService.buscar(2);
		
		Empleado empl = new Empleado();
		empl.setFechaIngreso(LocalDateTime.now());
		empl.setSalario(new BigDecimal(456));
		empl.setCiudadano(ciud3);
		
		Ciudadano ciud = new Ciudadano();
		
		Empleado empl = new Empleado();
		empl.setCiudadano(ciud);
		
		this.iEmpleadoService.guardar(empl);
		
		
		
		Empleado empl = new Empleado();
		
		Ciudadano ciud= new Ciudadano();
		ciud.setEmpleado(empl);
		ciud.setNombre("Jorge");
		ciud.setApellido("Abad");
		
		empl.setCiudadano(ciud);
		
		this.iCiudadanoService.guardar(ciud);*/
		
		Hotel hotel = new Hotel();
		hotel.setDireccion("Colon");
		hotel.setNombre("Marriot");
		
		Habitacion hab1= new Habitacion();
		hab1.setClase("Economica");
		hab1.setHotel(hotel);
		hab1.setNumero("A1");
		
		Habitacion hab2= new Habitacion();
		hab2.setClase("Presidencial");
		hab2.setHotel(hotel);
		hab2.setNumero("A2");

		List<Habitacion> habitaciones= new ArrayList<>();
		habitaciones.add(hab1);
		habitaciones.add(hab2);
		
		hotel.setHabitaciones(habitaciones);
		this.iHotelService.guardar(hotel);
		
		
	}

}
