package com.aravind.flightreservation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {
	
	private Integer noOfBags;
	private boolean checkedIn;
	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;
	
	
	
	
	public Integer getNoOfBags() {
		return noOfBags;
	}
	public void setNoOfBags(Integer noOfBags) {
		this.noOfBags = noOfBags;
	}
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	

}
