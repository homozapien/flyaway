package com.flyaway.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.flyaway.entities.FlightSchedule;
import com.flyaway.pojo.FlightSearch;

public class FlightSearchService {

	public static List<FlightSchedule> searchForMatchingFlight(List<FlightSchedule> scheduleList, FlightSearch flightSerach) 
	{
		Comparator<FlightSchedule> groupByComparator = Comparator.comparing(FlightSchedule::getFlightId)
				                                                 .thenComparing(FlightSchedule::getNumOfConnections)
				                                                 .thenComparing(FlightSchedule::getTicketPrice);		                                     	
		List<FlightSchedule> result = scheduleList.stream()
				.filter(schedule -> schedule.getCityAirportDept().getCode().equalsIgnoreCase(flightSerach.getDeptCityAirport())
						         && schedule.getCityAirportDest().getCode().equalsIgnoreCase(flightSerach.getDestCityAirport())
						         && (schedule.getAvailableDate().compareTo(flightSerach.getTravelDate()) == 0))
				.sorted(groupByComparator).collect(Collectors.toList()); 
		
		return result;
	}
}
