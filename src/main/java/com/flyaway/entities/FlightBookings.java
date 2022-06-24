package com.flyaway.entities;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flightsbookings")
public class FlightBookings 
{
	@Id
	private String bookingId;         //booking Id
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name = "custId",referencedColumnName = "custId")	
	private Set<Customers> setOfCustomer;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "FlightId")
	private AirlineFlights flight;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departureCity", referencedColumnName = "city")
	private CityAirports departureCity; //departure city / airport
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinationCity", referencedColumnName = "city")
	private CityAirports destinationCity; //destination city / airport
	
	private Date departureDate, returnDate;
	private double ticketPrice;
	private String confirmed; //Y or N based on payment services 
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public AirlineFlights getFlight() {
		return flight;
	}
	public void setFlight(AirlineFlights flight) {
		this.flight = flight;
	}
	public CityAirports getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(CityAirports departureCity) {
		this.departureCity = departureCity;
	}
	public CityAirports getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(CityAirports destinationCity) {
		this.destinationCity = destinationCity;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	public Set<Customers> getSetOfCustomer() {
		return setOfCustomer;
	}
	public void setSetOfCustomer(Set<Customers> setOfCustomer) {
		this.setOfCustomer = setOfCustomer;
	}
	
	
	
	
	
}
