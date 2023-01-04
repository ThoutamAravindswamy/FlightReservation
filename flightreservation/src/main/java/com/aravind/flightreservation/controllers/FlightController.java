package com.aravind.flightreservation.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.flightreservation.models.Flight;
import com.aravind.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("arrivalCity") String arrivalCity,@RequestParam("departureCity") String departureCity,@RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate dateOfDeparture,ModelMap modelMap) {
		
		List<Flight> flights = flightRepo.findFlights(arrivalCity, departureCity, dateOfDeparture);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
		
	}

}
