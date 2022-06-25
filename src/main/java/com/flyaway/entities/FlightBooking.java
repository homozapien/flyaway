package com.flyaway.entities;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flight_bookings")
public class FlightBooking 
{
	@Id
	private String bookingId;         //booking Id
	
	@OneToMany(cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY, 
			   mappedBy = "flightBooking")  
	//@JoinColumn(name = "cust_Id",referencedColumnName = "custId")	
	private Set<Customer> setOfCustomers;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id", referencedColumnName = "flightId")
	private AirlineFlight flight;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "departureCity", referencedColumnName = "city")
	private CityAirport departureCity; //departure city / airport
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destinationCity", referencedColumnName = "city")
	private CityAirport destinationCity; //destination city / airport */
	
	private Date departureDate, returnDate;
	private double ticketPrice;
	private String isFlightConfirmed; //Y or N based on payment services 
	private int numOfPassengers;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	
	public AirlineFlight getFlight() {
		return flight;
	}
	public void setFlight(AirlineFlight flight) {
		this.flight = flight;
	}
	/*public CityAirport getDepartureCity() {
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
	} */
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
	
	public Set<Customer> getSetOfCustomer() {
		return setOfCustomers;
	}
	public void setSetOfCustomer(Set<Customer> setOfCustomers) {
		this.setOfCustomers = setOfCustomers;
	}
	public Set<Customer> getSetOfCustomers() {
		return setOfCustomers;
	}
	public void setSetOfCustomers(Set<Customer> setOfCustomers) {
		this.setOfCustomers = setOfCustomers;
	}
	public int getNumOfPassengers() {
		return numOfPassengers;
	}
	public void setNumOfPassengers(int numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}
	public String getIsFlightConfirmed() {
		return isFlightConfirmed;
	}
	public void setIsFlightConfirmed(String isFlightConfirmed) {
		this.isFlightConfirmed = isFlightConfirmed;
	}
	
	
	
	
	
}
