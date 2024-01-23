package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.service.ICiudadanoService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ICiudadanoService ciudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Criteria API Query");
		
		Ciudadano ciudadano1 = this.ciudadanoService.buscarPorApellido("Paredes");
		System.out.println(ciudadano1);
		
		Ciudadano ciudadano2 = this.ciudadanoService.buscarPorCriteria("Maria", "Paredes", "1753341344");
		System.out.println(ciudadano2);
		
		Ciudadano ciudadano3 = this.ciudadanoService.buscarPorCriteria("Maria", "Paredes", "0553341344");
		System.out.println(ciudadano3);
		
		//Ciudadano ciudadano4 = this.ciudadanoService.buscarPorCriteria("Maria", "Paredes", "0653341344");
		//System.out.println(ciudadano4);
		
		Ciudadano ciudadano5= this.ciudadanoService.buscarPorCriteriaAndOr("Maria", "Paredes", "1753341344");
		System.out.println(ciudadano5);
		
		Ciudadano ciudadano6= this.ciudadanoService.buscarPorCriteriaAndOr("Maria", "Paredes", "0553341344");
		System.out.println(ciudadano6);
		

	}

}
