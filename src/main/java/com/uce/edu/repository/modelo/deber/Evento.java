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
@Table(name = "evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_evento")
	@SequenceGenerator(name = "seq_evento", sequenceName = "seq_evento", allocationSize = 1)
	@Column(name = "even_id")
	private Integer id;
	
	@Column(name = "even_nombre")
	private String nombre;
	
	@Column(name = "even_lugar")
	private String lugar;
	
	@Column(name = "even_fecha")
	private LocalDateTime fecha;
	
	//setter and getter
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	

}
