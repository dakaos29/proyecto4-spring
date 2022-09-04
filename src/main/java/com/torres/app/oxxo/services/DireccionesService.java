package com.torres.app.oxxo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torres.app.oxxo.dao.IDireccionesDao;
import com.torres.app.oxxo.entities.Direccion;

@Service
public class DireccionesService implements IDireccionesService{
	@Autowired
	private IDireccionesDao direccionesDao;

	@Override
	public List<Direccion> getAll() {
		// TODO Auto-generated method stub
		return (List<Direccion>)direccionesDao.findAll();
	}

	@Override
	public void save(Direccion direccion) {
		// TODO Auto-generated method stub
		direccionesDao.save(direccion);
		
	}

	@Override
	public Direccion getById(Long id) {
		// TODO Auto-generated method stub
		return direccionesDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		direccionesDao.deleteById(id);
		
	}

}
