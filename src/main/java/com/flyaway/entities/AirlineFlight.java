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
@Table(name = "flight_schedule")
public class AirlineFlight 
{
	@Id
	private String flightId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id", nullable=false, updatable=false, referencedColumnName = "id")
	private Airline airline;
	
	//Assumption:Specific flightId can only exist in a city / airport for a given day
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_city", referencedColumnName = "city")
	private CityAirport departureCity; //Depature City / Airport where this flight is available
	                                    //direction: A flightId can only be available in a
	
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_city", referencedColumnName = "city")	
	private CityAirport destinationCity;
	
	
    @OneToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "departure_country", referencedColumnName = "country")	
   	private CityAirport departureCountry;
    
    @OneToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "destination_country", referencedColumnName = "country")	
   	private CityAirport destinationCountry;
	
	private int numOfConnections;
	private double ticketPrice;
		
	private Date availableDate; //date this flight is available....
	                            //The key is: AirlineID, FlightNo, flightDate, and Departure city	
	
	public String getFlightId() 
	{
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Airline getAirline() {
		return airline;
	}
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public CityAirport getDepartureCity() 
	{
		return departureCity;
	}
	public void setDepartureCity(CityAirport departureCity) {
		this.departureCity = departureCity;
	}
	public CityAirport getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(CityAirport destinationCity) {
		this.destinationCity = destinationCity;
	}
	public CityAirport getDepartureCountry() {
		return departureCountry;
	}
	public void setDepartureCountry(CityAirport departureCountry) {
		this.departureCountry = departureCountry;
	}
	public CityAirport getDestinationCountry() {
		return destinationCountry;
	}
	public void setDestinationCountry(CityAirport destinationCountry) {
		this.destinationCountry = destinationCountry;
	}
	public int getNumOfConnections() {
		return numOfConnections;
	}
	public void setNumOfConnections(int numOfConnections) {
		this.numOfConnections = numOfConnections;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
		
	

}
