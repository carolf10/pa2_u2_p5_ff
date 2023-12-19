package com.uce.edu.repository.modelo.deber;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pelicula")
	@SequenceGenerator(name = "seq_pelicula", sequenceName = "seq_pelicula", allocationSize = 1)
	@Column(name = "peli_id")
	private Integer id;
	
	@Column(name = "peli_titulo")
	private String titulo;
	
	@Column(name = "peli_director")
	private String director;
	
	@Column(name = "peli_estreno")
	private LocalDateTime estreno;
	
	//setter and getter
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public LocalDateTime getEstreno() {
		return estreno;
	}
	public void setEstreno(LocalDateTime estreno) {
		this.estreno = estreno;
	}
	
	

}
