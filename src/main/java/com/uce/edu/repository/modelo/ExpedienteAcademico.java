package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "expediente_academico")
public class ExpedienteAcademico {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_expediente_academicoo")
	@SequenceGenerator(name = "seq_expediente_academico", sequenceName = "seq_expediente_academico", allocationSize = 1)
	@Column(name = "exac_id")
	private Integer id;
	@Column(name = "exac_codigo")
	private String codigo;
	@Column(name = "exac_fecha_graduacion")
	private LocalDateTime fechaGraduacion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exac_id_estudiante")
	private Estudiante estudiante;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getFechaGraduacion() {
		return fechaGraduacion;
	}
	public void setFechaGraduacion(LocalDateTime fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "ExpedienteAcademico [id=" + id + ", codigo=" + codigo + ", fechaGraduacion=" + fechaGraduacion + "]";
	}
	
	

}
