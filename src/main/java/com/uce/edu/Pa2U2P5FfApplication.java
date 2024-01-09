package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
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
		Libro2 libro = new Libro2();
		libro.setTitulo("JAVA");
		libro.setFechaPublicacion(LocalDateTime.now());

		Autor2 a1 = new Autor2();
		a1.setNacionalidad("Ecuatoriano");
		a1.setNombre("Pepito Teran2");

		Autor2 a2 = new Autor2();
		a2.setNacionalidad("Ecuatoriano");
		a2.setNombre("Daniel Teran2");

		List<Autor2> autores = new ArrayList<>();
		autores.add(a1);
		autores.add(a2);

		AutorLibro autorLibro= new AutorLibro();
		autorLibro.setLibro2(libro);
		autorLibro.setAutor2(a1);
		autorLibro.setFecha(LocalDateTime.now());
		
		AutorLibro autorLibro2= new AutorLibro();
		autorLibro2.setLibro2(libro);
		autorLibro2.setAutor2(a2);
		autorLibro2.setFecha(LocalDateTime.now());
		
		List<AutorLibro> autoresLibros = new ArrayList<>();
		autoresLibros.add(autorLibro);
		autoresLibros.add(autorLibro2);
		
		libro.setAutoresLibros(autoresLibros);
		
		//this.iLibroService.guardar(libro);
		
		Libro libroFinal= this.iLibroService.buscarPorNombre("JAVA");
		System.out.println(libroFinal);
	}

}
