package com.uce.edu;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import com.uce.edu.service.ICiudadanoService;
import com.uce.edu.service.IEmpleadoService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private IEmpleadoService iEmpleadoService;
	
	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano ciudadano= new Ciudadano();
		ciudadano.setNombre("Fatima");
		ciudadano.setApellido("Fiallos");
		
		Ciudadano ciud2= this.iCiudadanoService.buscar(1);
		
		Empleado empleado = new Empleado();
		empleado.setFechaIngreso(LocalDateTime.now());
		empleado.setSalario(new BigDecimal(450));
		empleado.setCiudadano(ciud2);
		this.iEmpleadoService.guardar(empleado);
		
	}

}
