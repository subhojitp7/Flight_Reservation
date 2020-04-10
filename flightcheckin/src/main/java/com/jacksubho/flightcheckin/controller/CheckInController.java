package com.jacksubho.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacksubho.flightcheckin.integration.ReservationRestClient;
import com.jacksubho.flightcheckin.integration.dto.Reservation;
import com.jacksubho.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap map) {
		Reservation reservation = restClient.findReservation(reservationId);
		map.addAttribute("reservation", reservation);
		return "displayReservation";
	}

	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
			@RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
		reservationUpdateRequest.setId(reservationId);
		reservationUpdateRequest.setCheckedIn(true);
		reservationUpdateRequest.setNumberOfBags(numberOfBags);
		restClient.updateReservation(reservationUpdateRequest);
		return "checkInConfirmation";
	}

}
