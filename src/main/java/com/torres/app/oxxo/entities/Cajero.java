package com.torres.app.oxxo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="cajeros")
public class Cajero {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "CUST_SEQ8")
			@SequenceGenerator(sequenceName = "customer_seq8",
			allocationSize = 1, name = "CUST_SEQ8")
	private Long id;
	
	@NotEmpty(message = "el nombre es un valor requerido")
	private String nombre;
	
	@NotEmpty(message = "el apellido paterno es un valor requerido")
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	@NotEmpty(message = "el apellido materno es un valor requerido")
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@NotEmpty(message = "el turno es un valor requerido")
	private String turno;
	
	@NotNull(message = "el salario es un valor requerido")
	private Double salario;
	
	@ManyToOne
	@JoinColumn(name="direccion_id")
	private Direccion direccion;
	
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private Sucursal sucursal;
	
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;

	public Cajero() {
		super();
	}

	public Cajero(Long id, @NotEmpty(message = "el nombre es un valor requerido") String nombre,
			@NotEmpty(message = "el apellido paterno es un valor requerido") String apPaterno,
			@NotEmpty(message = "el apellido materno es un valor requerido") String apMaterno,
			@NotEmpty(message = "el turno es un valor requerido") String turno,
			@NotNull(message = "el salario es un valor requerido") Double salario, Direccion direccion,
			Sucursal sucursal, Gerente gerente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.turno = turno;
		this.salario = salario;
		this.direccion = direccion;
		this.sucursal = sucursal;
		this.gerente = gerente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
}
