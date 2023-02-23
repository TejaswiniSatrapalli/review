package com.cg.hbm.service;


	
import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.exception.RecordNotFoundException;


@Service

public interface IHotelService {

	public Hotel addHotel(Hotel hotel);

	public List<Hotel> getAllHotels() ;

	public Hotel getHotelById(int id) throws RecordNotFoundException;

	public Hotel deleteHotelById(int hId);

	//public Hotel getHotelBystarRating(int snumber);
	public Hotel updateHotel(int hId);
	

	public List<Hotel> getHotelByCity(String city);

	

	}


