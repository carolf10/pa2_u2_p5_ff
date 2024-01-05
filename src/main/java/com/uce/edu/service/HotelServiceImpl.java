package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelRepository iHotelRepository;

	@Override
	public Hotel buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iHotelRepository.seleccionar(id);
	}

	@Override
	public void guardar(Hotel hotel) {
		this.iHotelRepository.insertar(hotel);

	}

	@Override
	public void actualizar(Hotel hotel) {
		this.iHotelRepository.actualizar(hotel);

	}

	@Override
	public void eliminar(Integer id) {
		this.iHotelRepository.eliminar(id);

	}

}
