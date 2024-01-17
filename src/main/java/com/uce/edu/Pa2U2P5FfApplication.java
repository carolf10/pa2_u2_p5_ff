package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Empleado empleado = this.iCiudadanoService.buscarPorCedula("1753341344");
		System.out.println(empleado);
		
		Ciudadano ciudadano2= this.iCiudadanoService.buscarPorCedulaCiu("1753341344");
		System.out.println(ciudadano2);
	}

}
