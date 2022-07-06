package com.flyaway.service;

import com.flyaway.dao.FlightBookingDao;
import com.flyaway.entities.FlightBooking;

public class FlightBookingService 
{
	
	FlightBookingDao dao = new FlightBookingDao ();
	
    public String createBookingWithPassenger(FlightBooking booking)
    {
    	return dao.createBookingWithPassenger(booking) == 1 ? "Success" : "Failure";   	
    }
    
    public int updateBookingDetails(String flightId)
	{
    	return dao.updateBookingDetails(flightId);
	}

}
