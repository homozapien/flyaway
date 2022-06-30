package com.flyaway.service;


import java.util.List;


import com.flyaway.dao.FlightScheduleDAO;
import com.flyaway.entities.FlightSchedule;

public class FlightScheduleService 
{
	FlightScheduleDAO dao = new FlightScheduleDAO ();
	
    public String createFlightSchedule(FlightSchedule schedule)
    {
    	return dao.createFlightSchedule(schedule) == 1 ? "Success" : "Failure";
    	
    }
    
   
    
    public List<FlightSchedule> getAllFlightSchedules()
    {
        return dao.getAllFlightSchedules();
    	 
    }
}
