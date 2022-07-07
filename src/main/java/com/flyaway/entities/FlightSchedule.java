package com.flyaway.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "flight_schedules" )
public class FlightSchedule implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String flightId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "airline_id", referencedColumnName = "id")
		//@JoinColumn(name = "airline_name", referencedColumnName = "name")
    })
	private Airline airline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depart_airport", referencedColumnName = "code")
	private CityAirport cityAirportDept; 
											

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "dest_airport", referencedColumnName = "code")
			//@JoinColumn(name = "destinationCountry", referencedColumnName = "country")

	})
	private CityAirport cityAirportDest; 
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "depart_airport", referencedColumnName = "code"),
		           @JoinColumn(name = "dest_airport", referencedColumnName = "code")

	})
	private CityAirport cityAirport; */
	

	private int numOfConnections;
	private double ticketPrice;
	
	

	public FlightSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Basic
	private LocalDate availableDate; 

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

	public LocalDate getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(LocalDate availableDate) {
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

	@Override
	public String toString() {
		return "FlightSchedule [flightId=" + flightId +  
				 ", numOfConnections=" + numOfConnections + ", ticketPrice="
				+ ticketPrice + ", availableDate=" + availableDate + "]";
	}
	
	/*@Override
	public String toString() {
		return "FlightSchedule [flightId=" + flightId + ", airline=" + getAirline().getId() + ", cityAirportDept=" + getCityAirportDept().getCode() 
				+ ", cityAirportDest=" + getCityAirportDest().getCode() + ", numOfConnections=" + numOfConnections + ", ticketPrice="
				+ ticketPrice + ", availableDate=" + availableDate + "]";
	}*/
	
	

}
