package com.aravind.flightcheckin.Integration.dto;


public class Reservation{
	
	private long id;
	private Integer noOfBags;
	private boolean checkedIn;
	private Passenger passenger;
	private Flight flight;
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
