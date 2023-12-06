package com.flight.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.service.dto.FlightBookingAcknowledgement;
import com.flight.service.dto.FlightBookingRequest;
import com.flight.service.service.FlightBookingService;

@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/flightBooking")
	public FlightBookingAcknowledgement flightBooking(@RequestBody FlightBookingRequest flightBookingRequest)
	{
		System.out.println(" passengerInfo --" + flightBookingRequest.getPassengerInfo());
		System.out.println("paymentInfo  -- " + flightBookingRequest.getPaymentInfo());
		return flightBookingService.bookFlightTicket(flightBookingRequest);
		
		
	}
}
