package com.torres.app.oxxo.services;

import java.util.List;

import com.torres.app.oxxo.entities.Direccion;

public interface IDireccionesService {
	
	public List<Direccion> getAll();
	public void save(Direccion direccion);
	public Direccion getById(Long id);
	public void delete(Long id);

}
