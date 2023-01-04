package com.aravind.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.flightreservation.dto.ReservationRequest;
import com.aravind.flightreservation.models.Flight;
import com.aravind.flightreservation.models.Reservation;
import com.aravind.flightreservation.repos.FlightRepository;
import com.aravind.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	ReservationService service;
	
	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId,ModelMap modelMap) {
		
		@SuppressWarnings("deprecation")
		Flight flight=flightRepo.getOne(flightId);
		modelMap.addAttribute("flight", flight);
		return"completeReservation";
		
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation = service.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is "+reservation.getId());
		return "reservationConfirmation";
	}

}
