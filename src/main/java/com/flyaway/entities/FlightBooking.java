package com.flyaway.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "flight_bookings")
public class FlightBooking implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String bookingId;         //booking Id
	
	@OneToMany(cascade = CascadeType.ALL,
			   fetch = FetchType.LAZY, 
			   mappedBy = "flightBooking")  
	private Set<Customer> setOfCustomers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		     @JoinColumn(name = "flightId",        referencedColumnName = "flightId"),		 
			 @JoinColumn(name = "departureDate",    referencedColumnName = "availableDate")
	})
	private FlightSchedule flightSchedule; 
	
	
	private Date returnDate;
	private double ticketPrice;
	private String isFlightConfirmed; //Y or N based on payment services 
	private int numOfPassengers;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
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
	public FlightSchedule getFlightSchedule() {
		return flightSchedule;
	}
	public void setFlightSchedule(FlightSchedule flightSchedule) {
		this.flightSchedule = flightSchedule;
	}
	
	/*public FlightSchedule getFlightScheduleDeptCity() {
		return flightScheduleDeptCity;
	}
	public void setFlightScheduleDeptCity(FlightSchedule flightScheduleDeptCity) {
		this.flightScheduleDeptCity = flightScheduleDeptCity;
	}
	public FlightSchedule getFlightScheduleDeptCntry() {
		return flightScheduleDeptCntry;
	}
	public void setFlightScheduleDeptCntry(FlightSchedule flightScheduleDeptCntry) {
		this.flightScheduleDeptCntry = flightScheduleDeptCntry;
	}
	public FlightSchedule getFlightScheduleDestCity() {
		return flightScheduleDestCity;
	}
	public void setFlightScheduleDestCity(FlightSchedule flightScheduleDestCity) {
		this.flightScheduleDestCity = flightScheduleDestCity;
	}
	public FlightSchedule getFlightScheduleDestCntry() {
		return flightScheduleDestCntry;
	}
	public void setFlightScheduleDestCntry(FlightSchedule flightScheduleDestCntry) {
		this.flightScheduleDestCntry = flightScheduleDestCntry; 
	}*/

	
	
}
