package com.aravind.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.flightreservation.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
