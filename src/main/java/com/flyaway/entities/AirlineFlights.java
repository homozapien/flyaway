package com.flyaway.entities;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "airlineflights")
public class AirlineFlights 
{
	@Id
	private String flightId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AirlineId", nullable=false, updatable=false, referencedColumnName = "id")
	private Airlines airline;
	
	//Assumption:Specific flightId can only exist in a city / airport for a given day
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departureCity", referencedColumnName = "city")
	private CityAirports departureCity; //Depature City / Airport where this flight is available
	                                    //direction: A flightId can only be available in a
		
	private Date availableDate; //date this flight is available....
	                            //The key is: AirlineID, FlightNo, flightDate, and Departure city
	
	public String getFlightId() 
	{
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Airlines getAirline() {
		return airline;
	}
	public void setAirline(Airlines airline) {
		this.airline = airline;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public CityAirports getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(CityAirports departureCity) {
		this.departureCity = departureCity;
	}
	
	
	
	
	

}
