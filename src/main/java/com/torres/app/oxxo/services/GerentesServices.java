package com.torres.app.oxxo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.app.oxxo.dao.IDireccionesDao;
import com.torres.app.oxxo.dao.IGerentesDao;
import com.torres.app.oxxo.dao.ISucursalesDao;
import com.torres.app.oxxo.entities.Direccion;
import com.torres.app.oxxo.entities.Gerente;
import com.torres.app.oxxo.entities.Sucursal;

@Service
public class GerentesServices implements IGerentesService {
	@Autowired
	private IGerentesDao gerentesDao;
	
	@Autowired
	private IDireccionesDao direccionesDao;
	
	@Autowired
	private ISucursalesDao sucursalesDao;

	@Override
	public List<Gerente> getAll() {
		// TODO Auto-generated method stub
		return (List<Gerente>) gerentesDao.findAll();
	}

	@Override
	public void save(Gerente gerente) {
		// TODO Auto-generated method stub
		gerentesDao.save(gerente);
		
	}

	@Override
	public Gerente getById(Long id) {
		// TODO Auto-generated method stub
		return gerentesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		gerentesDao.deleteById(id);
		
	}

	@Override
	public List<Direccion> getListaDirecciones() {
		// TODO Auto-generated method stub
		return (List<Direccion>)direccionesDao.findAll();
	}

	@Override
	public List<Sucursal> getListaSucursales() {
		// TODO Auto-generated method stub
		return (List<Sucursal>)sucursalesDao.findAll();
	}

}
