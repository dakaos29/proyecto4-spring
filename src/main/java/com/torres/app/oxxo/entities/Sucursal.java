package com.torres.app.oxxo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "CUST_SEQ6")
			@SequenceGenerator(sequenceName = "customer_seq6",
			allocationSize = 1, name = "CUST_SEQ6")
	private Long id;
	
	@NotEmpty(message = "el nombre es un valor requerido")
	private String nombre;
	
	@NotEmpty(message = "el telefono es requerido")
	private String telefono;
	
	@ManyToOne
	@JoinColumn(name="direccion_id")
	private Direccion direccion;
	
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;
	
	@JsonBackReference
	@OneToMany (mappedBy = "sucursal", cascade = CascadeType.ALL)
	private Set<Cajero> cajero = new HashSet<>();

	public Sucursal() {
		super();
	}

	public Sucursal(Long id, @NotEmpty(message = "el nombre es un valor requerido") String nombre,
			@NotEmpty(message = "el telefono es requerido") String telefono, Direccion direccion, Gerente gerente,
			Set<Cajero> cajero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.gerente = gerente;
		this.cajero = cajero;
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Set<Cajero> getCajero() {
		return cajero;
	}

	public void setCajero(Set<Cajero> cajero) {
		this.cajero = cajero;
	}
	
	

}
