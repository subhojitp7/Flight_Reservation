package com.jacksubho.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacksubho.flightreservation.dto.ReservationUpdateRequest;
import com.jacksubho.flightreservation.entities.Reservation;
import com.jacksubho.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepo;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		return reservationRepo.findById(id).get();
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepo.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepo.save(reservation);
	}

}
