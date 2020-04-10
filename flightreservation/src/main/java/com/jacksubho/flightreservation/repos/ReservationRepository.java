package com.jacksubho.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacksubho.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
