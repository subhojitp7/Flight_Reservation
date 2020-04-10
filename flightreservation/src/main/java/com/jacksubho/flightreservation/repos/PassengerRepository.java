package com.jacksubho.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksubho.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
