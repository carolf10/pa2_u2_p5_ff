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
		Libro libro = new Libro();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());
		
		Autor a1 = new Autor();
		a1.setNacionalidad("Ecuatoriano");
		a1.setNombre("Pepito Teran");
		
		Autor a2 = new Autor();
		a2.setNacionalidad("Ecuatoriano");
		a2.setNombre("Daniel Teran");
		
		Set<Autor> autores = new HashSet<Autor>();
		autores.add(a1);
		autores.add(a2);
		
		libro.setAutores(autores);
		
		Set<Libro> libros= new HashSet<>();
		libros.add(libro);
		
		a1.setLibros(libros);
		a2.setLibros(libros);
		
		this.iLibroService.guadar(libro);
		//insertar 1 autor que tiene varios libros
		//insertar 1 libro con varios autores
		
		

	}

}
