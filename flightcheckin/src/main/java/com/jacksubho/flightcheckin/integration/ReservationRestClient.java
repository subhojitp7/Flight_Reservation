package com.jacksubho.flightcheckin.integration;

import com.jacksubho.flightcheckin.integration.dto.Reservation;
import com.jacksubho.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
