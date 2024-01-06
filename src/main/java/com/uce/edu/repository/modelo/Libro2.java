package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

//@Entity
//@Table(name = "libro2")
public class Libro2 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro_p2")
	@SequenceGenerator(name = "seq_libro_p2", sequenceName = "seq_libro_p2", allocationSize = 1)
	@Column(name = "libr_id")
	private Integer id;
	
	@Column(name = "libr_titulo")
	private String titulo;
	
	@Column (name = "libr_fecha_publicacion")
	private LocalDateTime fechaPublicacion;
	
	private List<AutorLibro> autoresLibros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public List<AutorLibro> getAutoresLibros() {
		return autoresLibros;
	}

	public void setAutoresLibros(List<AutorLibro> autoresLibros) {
		this.autoresLibros = autoresLibros;
	}

}
