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
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "flightId")
	private AirlineFlight flight;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_city", referencedColumnName = "departure_city")
	private AirlineFlight departureCity; //departure city / airport
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_city", referencedColumnName = "destination_city")
	private AirlineFlight destinationCity; //destination city / airport 
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_country", referencedColumnName = "departure_country")
	private AirlineFlight departureCntry; //departure city / airport
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_country", referencedColumnName = "destination_country")
	private AirlineFlight destinationCntry; //destination city / airport 
	
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
	public AirlineFlight getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(AirlineFlight departureCity) {
		this.departureCity = departureCity;
	}
	public AirlineFlight getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(AirlineFlight destinationCity) {
		this.destinationCity = destinationCity;
	}
	public AirlineFlight getDepartureCntry() {
		return departureCntry;
	}
	public void setDepartureCntry(AirlineFlight departureCntry) {
		this.departureCntry = departureCntry;
	}
	public AirlineFlight getDestinationCntry() {
		return destinationCntry;
	}
	public void setDestinationCntry(AirlineFlight destinationCntry) {
		this.destinationCntry = destinationCntry;
	}
	
	
	
	
	
	
}
