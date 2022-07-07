package com.flyaway.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "passengers")
public class Passenger implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	private String passengerId; //e.g. passport number, DL
	private String firstname;
	private String lastname;
	private String emailId;
	private String creditCard;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId")
	private FlightBooking flightBooking;

	
	public Passenger(String passengerId, String firstname, String lastname, String emailId) {
		super();
		this.passengerId = passengerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
	}

	
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public FlightBooking getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(FlightBooking flightBooking) {
		this.flightBooking = flightBooking;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
    
}
