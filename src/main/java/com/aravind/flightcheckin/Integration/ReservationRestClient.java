package com.aravind.flightcheckin.Integration;

import com.aravind.flightcheckin.Integration.dto.Reservation;
import com.aravind.flightcheckin.Integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(long id);
	public Reservation updateReservation(ReservationUpdateRequest request);

}
