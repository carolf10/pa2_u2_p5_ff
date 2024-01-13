package com.uce.edu;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Con Query----------");
		List<Libro> lista= this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro l : lista) {
			System.out.println(l);
		}
		
		System.out.println("Con TypedQuery----------");
		Libro libro1= this.iLibroService.buscarPorTitulo("JAVA");
		System.out.println(libro1);
		
		List<Libro> lista2= this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro l : lista2) {
			System.out.println(l);
		}
		
		System.out.println("Con NamedQuery--------");
		Libro libro2= this.iLibroService.guadarPorTituloNamed("RStudio");
		System.out.println(libro2);
		
		List<Libro> lista3= this.iLibroService.buscarPorFecha(LocalDateTime.of(2023, 1, 1, 7, 15));
		for(Libro l : lista3) {
			System.out.println(l);
		}
		
	}

}
