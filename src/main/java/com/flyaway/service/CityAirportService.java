package com.flyaway.service;

import java.util.List;

import com.flyaway.dao.CityAiportDAO;
import com.flyaway.entities.CityAirport;

public class CityAirportService 
{
	CityAiportDAO dao = new CityAiportDAO ();
	
    public String createCityAirport(CityAirport cityAirport)
    {
    	return dao.createCityAirport(cityAirport) == 1 ? "Success" : "Failure";
    	
    }
    
    public List<CityAirport> getAllCityAirports()
    {
    	return dao.getAllCityAirports();
    }
}
