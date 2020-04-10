package com.jacksubho.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacksubho.flightreservation.dto.ReservationRequest;
import com.jacksubho.flightreservation.entities.Flight;
import com.jacksubho.flightreservation.entities.Passenger;
import com.jacksubho.flightreservation.entities.Reservation;
import com.jacksubho.flightreservation.repos.FlightRepository;
import com.jacksubho.flightreservation.repos.PassengerRepository;
import com.jacksubho.flightreservation.repos.ReservationRepository;
import com.jacksubho.flightreservation.util.EmailUtil;
import com.jacksubho.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private PassengerRepository passengerRepo;

	@Autowired
	private ReservationRepository reservationRepo;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// 3rd party payment gateway
		long flightId = request.getFlightId();
		Flight flight = flightRepo.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getFirstName());
		passenger.setLastName(request.getLastName());
		passenger.setEmail(request.getEmail());
		passenger.setPhone(request.getPhone());
		Passenger savedPassenger = passengerRepo.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepo.save(reservation);

		String filePath = "D:\\Reservations/reservation" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;
	}

}
