package com.aravind.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aravind.flightcheckin.Integration.dto.Reservation;
import com.aravind.flightcheckin.Integration.dto.ReservationUpdateRequest;
import com.aravind.flightcheckin.Integration.ReservationRestClient;

@Controller
public class CheckinController {
	
	@Autowired
	ReservationRestClient restClient;
	@RequestMapping("/showStartCheckin")
	public String showCheckin() {
		return "StartCheckin";
	}
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") long reservationId,ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckin(@RequestParam("reservationId") long reservationId,@RequestParam("noOfBags") int noOfBags) {
		
		ReservationUpdateRequest request =  new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setCheckedIn(true);
		request.setNoOfBags(noOfBags);
		restClient.updateReservation(request);
		return "checkInConfirmation";
		
	}

}
