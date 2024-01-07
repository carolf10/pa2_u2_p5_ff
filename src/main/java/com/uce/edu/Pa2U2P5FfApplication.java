package com.uce.edu;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.service.IAutorService;
import com.uce.edu.service.ILibroService;

@SpringBootApplication
public class Pa2U2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ILibroService iLibroService;
	@Autowired
	private IAutorService iAutorService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//insertar varios libro con varios autores
		/*Libro l1 = new Libro();
		l1.setTitulo("JAVA");
		l1.setFechaPublicacion(LocalDateTime.now());
		
		Libro l2 = new Libro();
		l2.setFechaPublicacion(LocalDateTime.now());
		l2.setTitulo("Mil años de soledad");
		
		Autor a1 = new Autor();
		a1.setNacionalidad("Ecuatoriano");
		a1.setNombre("Pepito Teran");
		
		Autor a2 = new Autor();
		a2.setNacionalidad("Colombiano");
		a2.setNombre("Gabriel Garcia Marquez");
		
		Set<Autor> autores1 = new HashSet<Autor>();
		autores1.add(a1);
		autores1.add(a2);
		
		l1.setAutores(autores1);
		l2.setAutores(autores1);
		
		Set<Libro> libros1= new HashSet<>();
		libros1.add(l1);
		libros1.add(l2);
		
		a1.setLibros(libros1);
		a2.setLibros(libros1);
		
		//this.iLibroService.guardar(l1);
		//this.iLibroService.guardar(l2);
		//this.iAutorService.guardar(a1);
		this.iAutorService.guardar(a2);*/
		
		//insertar 1 autor que tiene varios libros
		Autor a3 = new Autor();
		a3.setNacionalidad("Ecuatoriano");
		a3.setNombre("Paulo Coello");
		
		Set<Autor> autores2 = new HashSet<Autor>();
		autores2.add(a3);
		
		Libro l3 = new Libro();
		l3.setTitulo("El viaje al centro de la tierra");
		l3.setFechaPublicacion(LocalDateTime.now());
		l3.setAutores(autores2);
		
		Libro l4 = new Libro();
		l4.setFechaPublicacion(LocalDateTime.now());
		l4.setTitulo("Meridia");
		l4.setAutores(autores2);
		
		Set<Libro> libros2= new HashSet<>();
		libros2.add(l3);
		libros2.add(l4);
		
		a3.setLibros(libros2);
		
		this.iAutorService.guardar(a3);

	}

}
