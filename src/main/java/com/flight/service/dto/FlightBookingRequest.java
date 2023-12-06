package com.flight.service.dto;

import com.flight.service.entity.PassengerInfo;
import com.flight.service.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

	private PassengerInfo passengerInfo;
	
	private PaymentInfo paymentInfo;
}
