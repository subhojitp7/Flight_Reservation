package com.jacksubho.flightreservation.services;

import com.jacksubho.flightreservation.dto.ReservationRequest;
import com.jacksubho.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
