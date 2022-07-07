package com.flyaway.service;

import java.util.List;

import com.flyaway.dao.FlightBookingDao;
import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.Passenger;

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
    
    public FlightBooking findABookingDetail(String bookingId)
	{
    	return dao.findABookingDetail(bookingId);
	}
    
    public List<Passenger> findPassengersBookingDetail(String bookingId)
	{
    	return dao.findPassengersBookingDetail(bookingId);
	}
    
    public List<Passenger> findAllPassengersBookingDetail()
	{
    	return dao.findAllPassengersBookingDetail();
	}
    
    public List<FlightBooking> findMyBookingDetails(String bookedBy)
	{
    	 return dao.findMyBookingDetails(bookedBy);
	}
    
    public List<FlightBooking> getAllBookingDetails()
    {
    	 return dao.getAllBookingDetails();
    }

}
