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
@Table(name = "customers")
public class Customer implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	private String custId;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable=false, updatable=false, referencedColumnName = "bookingId")
	private FlightBooking flightBooking;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public FlightBooking getFlightBooking() {
		return flightBooking;
	}

	public void setFlightBooking(FlightBooking flightBooking) {
		this.flightBooking = flightBooking;
	}
	
	

}
