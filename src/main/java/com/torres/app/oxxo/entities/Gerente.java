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

@Entity
@Table(name="gerentes")
public class Gerente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "CUST_SEQ7")
			@SequenceGenerator(sequenceName = "customer_seq7",
			allocationSize = 1, name = "CUST_SEQ7")
	private Long id;
	
	@NotEmpty(message = "el nombre es un valor requerido")
	private String nombre;
	
	@NotEmpty(message = "el apellido paterno es un valor requerido")
	@Column(name = "ap_paterno")
	private String apPaterno;
	
	@NotEmpty(message = "el apellido materno es un valor requerido")
	@Column(name = "ap_materno")
	private String apMaterno;
	
	@NotEmpty(message = "el telefono es requerido")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="direccion_id")
	private Direccion direccion;
	
	@ManyToOne
	@JoinColumn(name="sucursal_id")
	private Sucursal sucursal;

	public Gerente() {
		super();
	}

	public Gerente(Long id, @NotEmpty(message = "el nombre es un valor requerido") String nombre,
			@NotEmpty(message = "el apellido paterno es un valor requerido") String apPaterno,
			@NotEmpty(message = "el apellido materno es un valor requerido") String apMaterno,
			@NotEmpty(message = "el telefono es requerido") String telefono, Direccion direccion, Sucursal sucursal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefono = telefono;
		this.direccion = direccion;
		this.sucursal = sucursal;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

}
