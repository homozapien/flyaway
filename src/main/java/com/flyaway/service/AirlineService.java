package com.flyaway.service;

import java.util.List;

import com.flyaway.dao.AirlineDAO;
import com.flyaway.dao.CityAiportDAO;
import com.flyaway.entities.Airline;
import com.flyaway.entities.CityAirport;

public class AirlineService 
{
	AirlineDAO dao = new AirlineDAO ();
	
    public String createAirline(Airline airline)
    {
    	return dao.createAirline(airline) == 1 ? "Success" : "Failure";
    	
    }
    
    public List<Airline> getAllAirlines()
    {
    	return dao.getAllAirlines();
    }
}
