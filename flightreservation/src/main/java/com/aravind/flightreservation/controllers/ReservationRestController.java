package com.aravind.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aravind.flightreservation.dto.ReservationUpdateRequest;
import com.aravind.flightreservation.models.Reservation;
import com.aravind.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	ReservationRepository reservationRepo;
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		
		return reservationRepo.findById(id).get();
		
	}
	
	@RequestMapping("/reservations/")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		Reservation reservation=reservationRepo.findById(request.getId()).get();
		reservation.setNoOfBags(request.getNoOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		return reservationRepo.save(reservation);
		
	}

}
