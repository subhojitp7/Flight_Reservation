package com.jacksubho.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacksubho.flightreservation.dto.ReservationRequest;
import com.jacksubho.flightreservation.entities.Flight;
import com.jacksubho.flightreservation.entities.Reservation;
import com.jacksubho.flightreservation.repos.FlightRepository;
import com.jacksubho.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap map) {
		Flight flight = flightRepo.findById(flightId).get();
		map.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap map) {
		Reservation reservation = reservationService.bookFlight(request);
		map.addAttribute("msg", "Reservation successfull with Reservation Id : " + reservation.getId());
		return "reservationConfirmation";
	}

}
