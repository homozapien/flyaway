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
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "flight_bookings", uniqueConstraints = { @UniqueConstraint(columnNames = { "bookingId", "flightId"})})
public class FlightBooking implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	private String bookingId;         
	
	@OneToMany(cascade = CascadeType.ALL,
			  // fetch = FetchType.LAZY, 
			   mappedBy = "flightBooking")  
	private Set<Passenger> passengers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flightId",        referencedColumnName = "flightId")
	private FlightSchedule flightSchedule; 
	
	private String isFlightConfirmed; //Y or N based on payment services 
	private int numOfPassengers;
	private String bookedBy;
	
	public FlightBooking(String bookingId, String isFlightConfirmed, int numOfPassengers, String bookedBy) {
		super();
		this.bookingId = bookingId;
		this.isFlightConfirmed = isFlightConfirmed;
		this.numOfPassengers = numOfPassengers;
		this.bookedBy = bookedBy;
	}
	
	
	
	public FlightBooking() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	
	public Set<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
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
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}	
	
}
