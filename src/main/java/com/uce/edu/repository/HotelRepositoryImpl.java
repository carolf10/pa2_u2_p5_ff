package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public Hotel seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.manager.find(Hotel.class, id);
	}

	@Override
	public void insertar(Hotel hotel) {
		this.manager.persist(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.manager.merge(hotel);
		
	}

	@Override
	public void eliminar(Integer id) {
		Hotel hotel= this.seleccionar(id);
		this.manager.remove(hotel);
		
	}

}
