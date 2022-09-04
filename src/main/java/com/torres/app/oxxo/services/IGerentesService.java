package com.torres.app.oxxo.services;

import java.util.List;

import com.torres.app.oxxo.entities.Direccion;
import com.torres.app.oxxo.entities.Gerente;
import com.torres.app.oxxo.entities.Sucursal;


public interface IGerentesService {
	public List<Gerente> getAll();
	public void save(Gerente gerente);
	public Gerente getById(Long id);
	public void delete(Long id);
	
	public List<Direccion> getListaDirecciones();
	
	public List<Sucursal> getListaSucursales();

}
