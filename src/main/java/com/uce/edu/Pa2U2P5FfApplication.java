package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import com.uce.edu.service.IHabitacionService;
import com.uce.edu.service.IHotelService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private IHabitacionService iHabitacionService;
	
	@Autowired
	private IHotelService iHotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Ejemplo 1
		Hotel h1 = new Hotel();
		h1.setDireccion("Patria");
		h1.setNombre("Hilton Colon");
		Habitacion ha11= new Habitacion();
		Habitacion ha12= new Habitacion();
		List<Habitacion> habitaciones1= new ArrayList<>();
		habitaciones1.add(ha12);
		habitaciones1.add(ha11);
		h1.setHabitaciones(habitaciones1);
		this.iHotelService.guardar(h1);*/
		
		/*//Ejemplo 2
		Hotel h2 = new Hotel();
		Habitacion ha2 = new Habitacion();
		ha2.setClase("Economico");
		ha2.setHotel(h2);
		ha2.setNumero("E1");
		this.iHabitacionService.guardar(ha2);*/
		
		//Ejemplo 3
		Hotel h3= new Hotel();
		h3.setDireccion("Patria");
		h3.setNombre("Tambo Real");
		Habitacion ha31 = new Habitacion();
		ha31.setClase("Presidencial");
		ha31.setNumero("P1");
		Habitacion ha32 = new Habitacion();
		ha32.setClase("Economico");
		ha32.setNumero("E2");
		List<Habitacion> habitaciones3 = new ArrayList<>();
		habitaciones3.add(ha32);
		habitaciones3.add(ha31);
		h3.setHabitaciones(habitaciones3);
		//this.iHotelService.guardar(h3);
		
		//Ejemplo 4
		this.iHabitacionService.eliminar(2);
		
		h3.setNombre("Nuevo Tambo Real");
		this.iHotelService.actualizar(h3);
		

	}

}
