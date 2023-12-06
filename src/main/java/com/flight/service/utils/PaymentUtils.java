package com.flight.service.utils;

import java.util.HashMap;
import java.util.Map;

import com.flight.service.exception.InsufficientAmountException;

public class PaymentUtils {

	private static Map<String,Double> paymentMap = new HashMap<>();
	
	static{
		paymentMap.put("Acc1", 12000.0);
		paymentMap.put("Acc2", 10000.0);
		paymentMap.put("Acc3", 5000.0);
		paymentMap.put("Acc4", 8000.0);
	}
	
	public static boolean validateCreditLimit(String accNo, double paidAmount)
	{
		if(paidAmount > paymentMap.get(accNo))
			throw new InsufficientAmountException("insufficient fund..!");
		else
			return true;
	}
}
