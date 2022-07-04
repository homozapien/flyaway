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
				.filter(schedule -> schedule.getCityAirportDept().getCity().equalsIgnoreCase(flightSerach.getDeptCity())
						         && schedule.getCityAirportDept().getCountry().equalsIgnoreCase(flightSerach.getDeptCntry())
						         && schedule.getCityAirportDest().getCity().equalsIgnoreCase(flightSerach.getDestCity())
						         && schedule.getCityAirportDest().getCountry().equalsIgnoreCase(flightSerach.getDestCntry()))
						        // && (schedule.getAvailableDate().compareTo(flightSerach.getTravelDate()) == 0))
				.sorted(groupByComparator).collect(Collectors.toList());
		
		return result;
	}
}
