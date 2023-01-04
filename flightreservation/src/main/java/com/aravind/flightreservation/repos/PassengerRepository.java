package com.aravind.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.flightreservation.models.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
