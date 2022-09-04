package com.torres.app.oxxo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name = "direccionesOxxo")
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "CUST_SEQ5")
			@SequenceGenerator(sequenceName = "customer_seq5",
			allocationSize = 1, name = "CUST_SEQ5")
	private Long id;
	
	@NotEmpty(message = "la calle es un valor requerido")
	private String calle;
	
	@NotEmpty(message = "el numero de calle es un valor requerido")
	private String numero;
	
	@NotEmpty(message = "la colonia es un valor requerido")
	private String colonia;
	
	@NotEmpty(message = "la ciudad es un valor requerido")
	private String ciudad;
	
	@NotEmpty(message = "el estado es un valor requerido")
	private String estado;
	
	@NotEmpty(message = "el codigo postal es un valor requerido")
	private String cp;

	public Direccion() {
		super();
	}

	public Direccion(Long id, @NotEmpty(message = "la calle es un valor requerido") String calle,
			@NotEmpty(message = "el numero de calle es un valor requerido") String numero,
			@NotEmpty(message = "la colonia es un valor requerido") String colonia,
			@NotEmpty(message = "la ciudad es un valor requerido") String ciudad,
			@NotEmpty(message = "el estado es un valor requerido") String estado,
			@NotEmpty(message = "el codigo postal es un valor requerido") String cp) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.colonia = colonia;
		this.ciudad = ciudad;
		this.estado = estado;
		this.cp = cp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}
	

}
