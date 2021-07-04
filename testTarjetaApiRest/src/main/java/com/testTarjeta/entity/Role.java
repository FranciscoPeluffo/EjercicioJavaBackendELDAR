package com.testTarjeta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private int marca;
	
	@Column
	private double diaTransaccion;
	
	@Column
	private double mesTransaccion;
	
	@Column
	private double anioTransaccion;
	
	@Column
	private double monto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public double getDiaTransaccion() {
		return diaTransaccion;
	}

	public void setDiaTransaccion(double diaTransaccion) {
		this.diaTransaccion = diaTransaccion;
	}

	public double getMesTransaccion() {
		return mesTransaccion;
	}

	public void setMesTransaccion(double mesTransaccion) {
		this.mesTransaccion = mesTransaccion;
	}

	public double getAnioTransaccion() {
		return anioTransaccion;
	}

	public void setAnioTransaccion(double anioTransaccion) {
		this.anioTransaccion = anioTransaccion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
