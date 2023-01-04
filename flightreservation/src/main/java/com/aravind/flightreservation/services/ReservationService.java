package com.aravind.flightreservation.services;

import org.springframework.stereotype.Service;

import com.aravind.flightreservation.dto.ReservationRequest;
import com.aravind.flightreservation.models.Reservation;


public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
}
