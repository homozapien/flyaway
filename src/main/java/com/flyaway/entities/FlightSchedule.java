package com.flyaway.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedules")
public class FlightSchedule implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String flightId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id", referencedColumnName = "id")
	private Airline airline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "departureCity", referencedColumnName = "city"),
			@JoinColumn(name = "departureCountry", referencedColumnName = "country")

	})
	private CityAirport cityAirportDept; 
											

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "destinationCity", referencedColumnName = "city"),
			@JoinColumn(name = "destinationCountry", referencedColumnName = "country")

	})
	private CityAirport cityAirportDest; 
	
	
											

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "flightSchedule")
	private List<FlightBooking> listOfFlightBookings; */

	

	private int numOfConnections;
	private double ticketPrice;

	private Date availableDate; // date this flight is available....
								// The key is: AirlineID, FlightNo, flightDate, and Departure city

	public String getFlightId() {
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

	public CityAirport getCityAirportDept() {
		return cityAirportDept;
	}

	public void setCityAirportDept(CityAirport cityAirportDept) {
		this.cityAirportDept = cityAirportDept;
	}

	public CityAirport getCityAirportDest() {
		return cityAirportDest;
	}

	public void setCityAirportDest(CityAirport cityAirportDest) {
		this.cityAirportDest = cityAirportDest;
	}

	/*public List<FlightBooking> getListOfFlightBookings() {
		return listOfFlightBookings;
	}

	public void setListOfFlightBookings(List<FlightBooking> listOfFlightBookings) {
		this.listOfFlightBookings = listOfFlightBookings;
	} */

}
