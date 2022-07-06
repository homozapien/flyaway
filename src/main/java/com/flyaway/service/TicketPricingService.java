package com.flyaway.service;

public class TicketPricingService
{
	public static double calculateTicketPrice(String ticketPrice, int passengerNum)
	{
		//implement any special business logic here for ticket price
		double price = Double.valueOf(ticketPrice);
		
		double tax = 0.085 * price;
		
		return passengerNum * (price + tax);
	}

}
