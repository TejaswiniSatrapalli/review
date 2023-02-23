package com.cg.hbm.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Hotel")
@Entity
@Data

@NoArgsConstructor
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int hotelId;
	private String city;
	private String hotelName;
	private String address;
	private String description;
	private double avgRatePerDay;
	private String email;
	private String phone;
	private String website;
	private Number starRating;
	private String imageName;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="hotelId")
	private List<RoomDetails> rooms;
	

	public Hotel(String city, String hotelName, String address, String description, double avgRatePerDay, String email,
			String phone1, String website,Number starRating,String imageName) {
		super();
		this.city = city;
		this.hotelName = hotelName;
		this.address = address;
		this.description = description;
		this.avgRatePerDay = avgRatePerDay;
		this.email = email;
		this.phone = phone;
		this.website = website;
		this.starRating=starRating;
		this.imageName=imageName;
		
	}


	public static int size() {
		// TODO Auto-generated method stub
		return 0;
	}


}
