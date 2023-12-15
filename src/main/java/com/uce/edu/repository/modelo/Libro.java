package com.uce.edu.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
	@SequenceGenerator(name = "seq_libro", sequenceName = "seq_libro", allocationSize = 1)
	@Column(name = "lib_id")
	private Integer id;
	
	@Column(name = "lib_titulo")
	private String titulo;
	
	@Column(name = "lib_autor")
	private String autor;
	
	@Column(name = "lib_num_copias")
	private Integer numCopias;
	
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
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumCopias() {
		return numCopias;
	}
	public void setNumCopias(Integer numCopias) {
		this.numCopias = numCopias;
	}
	
	
}
