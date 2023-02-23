package com.cg.hbm.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Hotel;
@Repository


public interface IHotelRepository extends JpaRepository<Hotel,Integer> {
    

	public Hotel save(int hotelId);

	public List<Hotel> getHotelByCity(String city);
}
