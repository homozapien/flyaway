package com.flyaway.entities;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "airports", uniqueConstraints = { @UniqueConstraint(columnNames = { "code", "city", "country"}) })
public class CityAirport implements Serializable
{
	private static final long serialVersionUID = 3756680645803624405L;
	@Id
	private String code;      //unique airport code 
	@Column(unique=false)
	private String city;      //city (model: source or destination)
	@Column(unique=false)
	private String country;   //country where city is located
	
	/* @OneToMany(fetch = FetchType.LAZY,   		   
  		   mappedBy = "departureCity")  
	@JoinColumn(name = "flightId")	
    private Set<AirlineFlights> setOfflights; */
	
	
	
	public String getCode() {
		return code;
	}
	
	public CityAirport(String code, String city, String country) {
		super();
		this.code = code;
		this.city = city;
		this.country = country;
	}
	
	
	public CityAirport() {
		super();		
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/*public Set<AirlineFlights> getSetOfflights() {
		return setOfflights;
	}
	public void setSetOfflights(Set<AirlineFlights> setOfflights) {
		this.setOfflights = setOfflights;
	}*/
	
	
	
}
