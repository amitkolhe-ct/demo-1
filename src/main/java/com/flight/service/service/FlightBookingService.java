package com.flight.service.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.service.dto.FlightBookingAcknowledgement;
import com.flight.service.dto.FlightBookingRequest;
import com.flight.service.entity.PassengerInfo;
import com.flight.service.entity.PaymentInfo;
import com.flight.service.repositoty.PassengerInforepository;
import com.flight.service.repositoty.PaymentInfoRepository;
import com.flight.service.utils.PaymentUtils;

import jakarta.transaction.Transactional;

@Service
public class FlightBookingService {
	
	@Autowired
	private PassengerInforepository passengerInforepository;
	
	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Transactional
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest)
	{
		
		PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
		System.out.println(" passengerInfo --" + passengerInfo);
		passengerInforepository.save(passengerInfo);
		
		PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
		System.out.println("paymentInfo  -- " + paymentInfo);
		PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getId());
		paymentInfo.setAmount(passengerInfo.getFare());
		paymentInfoRepository.save(paymentInfo);
		return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);
		
	}
}
