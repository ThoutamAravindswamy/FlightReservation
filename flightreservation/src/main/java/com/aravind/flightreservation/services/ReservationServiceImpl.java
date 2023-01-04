package com.aravind.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aravind.flightreservation.dto.ReservationRequest;
import com.aravind.flightreservation.models.Flight;
import com.aravind.flightreservation.models.Passenger;
import com.aravind.flightreservation.models.Reservation;
import com.aravind.flightreservation.repos.FlightRepository;
import com.aravind.flightreservation.repos.PassengerRepository;
import com.aravind.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	PassengerRepository passengerRepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	Passenger pass;

	public Reservation bookFlight(ReservationRequest request) {
		
		long flightId = request.getFlightId();
		@SuppressWarnings("deprecation")
		Flight flight = flightRepo.findById(flightId).get();
		Passenger passenger =new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setId(request.getPassengerId());
		Passenger savedPassenger = passengerRepo.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepo.save(reservation);
		return savedReservation;
	}

}
