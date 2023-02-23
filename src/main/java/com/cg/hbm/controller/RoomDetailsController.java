package com.cg.hbm.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.RoomDetailsAdminResponseDTO;
import com.cg.hbm.dto.RoomDetailsDTO;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.exception.RoomDetailsIdNotFoundException;
import com.cg.hbm.service.IRoomDetailsService;
import com.cg.hbm.util.RoomDetailsDTOConvertor;

@RestController
@RequestMapping("/roomDetails")
public class RoomDetailsController {

	@Autowired
	IRoomDetailsService roomDetailsService;
	
	@Autowired
	RoomDetailsDTOConvertor roomDetailsDTOConvertor;
	
	@PostMapping("/add")
	public ResponseEntity<RoomDetails> addRoomDetails(@RequestBody RoomDetails cRoomDetails) throws RoomDetailsIdNotFoundException {

		RoomDetails newRoomDetails = roomDetailsService.addRoomDetails(cRoomDetails);
		RoomDetailsAdminResponseDTO responseDTO = roomDetailsDTOConvertor.getRoomDetailsAdminResponseDTO(newRoomDetails);

		return new ResponseEntity<RoomDetails>(newRoomDetails, HttpStatus.OK);
	}

	@PutMapping("/roomDetails/update")
	public ResponseEntity<RoomDetails> updateRoomDetails(@RequestBody RoomDetails cRoomDetails) throws RoomDetailsIdNotFoundException {

		RoomDetails updatedRoomDetails =roomDetailsService.updateRoomDetails(cRoomDetails);
		RoomDetailsAdminResponseDTO responseDTO = roomDetailsDTOConvertor.getRoomDetailsAdminResponseDTO(updatedRoomDetails);
		
       
		return new ResponseEntity<RoomDetails>(updatedRoomDetails, HttpStatus.OK);
        
	}
	@DeleteMapping("/roomDetails/remove/{rID}")
	public ResponseEntity<RoomDetails> removeRoomDetails(@PathVariable Integer rID) throws RoomDetailsIdNotFoundException {
       if(rID == null) {
    	   throw new RoomDetailsIdNotFoundException("No customer exist with this key");
       }
       else {
    	   RoomDetails removeRoomDetails = roomDetailsService.removeRoomDetails(rID);

		return new ResponseEntity<RoomDetails>(removeRoomDetails, HttpStatus.OK);
       }
         
	}

	@GetMapping("/roomDetails/show/{rID}")
	public ResponseEntity<RoomDetails> showRoomDetails(@PathVariable Integer rID) throws RoomDetailsIdNotFoundException {

		RoomDetails showRoomDetails = roomDetailsService.removeRoomDetails(rID);

		return new ResponseEntity<RoomDetails>(showRoomDetails, HttpStatus.OK);
	}
	/*@GetMapping("/allrooms/{id}")
	public ResponseEntity<List<RoomDetailsDTO>> getAllTrips( @PathVariable("id") int hotelId) 
	{
		List<RoomDetails> allroomsinDB = roomDetailsService.viewAllRoomsByHotelId(hotelId);
		
		List<RoomDetailsDTO> dtoList = new ArrayList<>();
		for (RoomDetails roomDetails : allroomsinDB) {
			
			RoomDetailsDTO dtoObj = roomDetailsDTOConvertor.getRoomDetailsDTO( roomDetails);
			dtoList.add(dtoObj);
		}
		
		return new ResponseEntity<List<RoomDetailsDTO>>(dtoList,HttpStatus.OK);
	}*/
	
	
}
