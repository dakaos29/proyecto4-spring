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
public class SucursalesService implements ISucursalesService {
	@Autowired
	private ISucursalesDao sucursalesDao;
	
	@Autowired
	private IGerentesDao gerentesDao;
	
	@Autowired
	private IDireccionesDao direccionesDao;

	@Override
	public List<Sucursal> getAll() {
		// TODO Auto-generated method stub
		return (List<Sucursal>) sucursalesDao.findAll();
	}

	@Override
	public void save(Sucursal sucursal) {
		// TODO Auto-generated method stub
		sucursalesDao.save(sucursal);
		
	}

	@Override
	public Sucursal getById(Long id) {
		// TODO Auto-generated method stub
		return sucursalesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sucursalesDao.deleteById(id);
		
	}

	@Override
	public List<Direccion> getListaDirecciones() {
		// TODO Auto-generated method stub
		return (List<Direccion>)direccionesDao.findAll();
	}

	@Override
	public List<Gerente> getListaGerentes() {
		// TODO Auto-generated method stub
		return (List<Gerente>)gerentesDao.findAll();
	}

}
