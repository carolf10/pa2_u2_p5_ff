package com.uce.edu.transferencia.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//@Entity
//@Table (name = "transferencia")
public class Transferencia {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transferencia")
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@Column(name = "trans_id")*/
	private Integer id;
	
	//@Column (name = "trans_numer")
	private String numero;
	
	//@Column(name = "trans_fecha")
	private LocalDateTime fecha;
	
	//@Column(name="trans_monto")
	private BigDecimal monto;
	
	//@Column(name = "")
	private CuentaBancaria cuentaOrigen;
	private CuentaBancaria cuentaDestino;
	
	
	@Override
	public String toString() {
		return "Transferencia [numero=" + numero + ", fecha=" + fecha + ", monto=" + monto + ", cuentaOrigen="
				+ cuentaOrigen + ", cuentaDestino=" + cuentaDestino + "]";
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public CuentaBancaria getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public CuentaBancaria getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(CuentaBancaria cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
}
