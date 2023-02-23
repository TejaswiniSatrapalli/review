package com.cg.hbm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.exception.RoomDetailsIdNotFoundException;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.repository.IRoomDetailsRepository;

@Service
public class RoomDetailsServiceImpl implements IRoomDetailsService {

	@Autowired
	private IRoomDetailsRepository roomDetailsRepo;
	
	@Autowired
	private IHotelRepository hotelRepository;
	

	@Override
	@Transactional
	public RoomDetails addRoomDetails(RoomDetails roomDetails) throws RoomDetailsIdNotFoundException {
		// TODO Auto-generated method stub
		RoomDetails savedRoomDetails=roomDetailsRepo.save(roomDetails);
		if(savedRoomDetails!=null) {
			return savedRoomDetails;
		}
		else {
			throw new RoomDetailsIdNotFoundException("no such roomDetails");
		}
	}

	@Override
	@Transactional
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) throws RoomDetailsIdNotFoundException{
		Optional<RoomDetails> updateroomDetails=roomDetailsRepo.findById(roomDetails.getRoomId());
		if(updateroomDetails.isPresent()) {
			return roomDetailsRepo.save(roomDetails);
		}
		else {
			throw new RoomDetailsIdNotFoundException("Invalid roomDetails details");
		}
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public RoomDetails removeRoomDetails(int roomDetailsId) throws RoomDetailsIdNotFoundException {
		// TODO Auto-generated method stub
		RoomDetails exsistingRoomDetails=roomDetailsRepo.findById(roomDetailsId).orElseThrow(() -> new RoomDetailsIdNotFoundException("RoomDetails is not listed"+roomDetailsId));
		
		roomDetailsRepo.delete(exsistingRoomDetails);
		return exsistingRoomDetails;
		
	}

	
	

	/*@Override
	public List<RoomDetails> viewAllRoomsByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		Hotel savedUser = hotelRepository.getReferenceById(hotelId);
		List<RoomDetails> abc = roomDetailsRepo.getRoomsByHotelId(savedUser);
		return abc;
	}*/

	
	

	

}