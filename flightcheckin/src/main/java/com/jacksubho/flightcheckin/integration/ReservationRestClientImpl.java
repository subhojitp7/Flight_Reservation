package com.jacksubho.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jacksubho.flightcheckin.integration.dto.Reservation;
import com.jacksubho.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATIONS_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(long id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate
				.getForObject(RESERVATIONS_REST_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATIONS_REST_URL, request, Reservation.class);
		return reservation;
	}

}
