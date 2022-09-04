package com.torres.app.oxxo.services;

import java.util.List;

import com.torres.app.oxxo.entities.Gerente;
import com.torres.app.oxxo.entities.Direccion;
import com.torres.app.oxxo.entities.Sucursal;


public interface ISucursalesService {
	public List<Sucursal> getAll();
	public void save(Sucursal sucursal);
	public Sucursal getById(Long id);
	public void delete(Long id);
	
	public List<Direccion> getListaDirecciones();
	
	public List<Gerente> getListaGerentes();

}
