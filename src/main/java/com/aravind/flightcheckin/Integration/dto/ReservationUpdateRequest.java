package com.aravind.flightcheckin.Integration.dto;

public class ReservationUpdateRequest {
	private long id;
	private boolean checkedIn;
	private Integer noOfBags;
	
	
	public Integer getNoOfBags() {
		return noOfBags;
	}
	public void setNoOfBags(Integer noOfBags) {
		this.noOfBags = noOfBags;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	
	

}
