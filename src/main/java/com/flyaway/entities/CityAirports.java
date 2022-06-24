package com.flyaway.entities;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cityairports")
public class CityAirports 
{
	@Id
	private String code;      //unique airport code 
	private String city;      //city (model: source or destination)
	private String country;   //country where city is located
	
	 @OneToMany(fetch = FetchType.LAZY,   		   
  		   mappedBy = "departureCity")  
	@JoinColumn(name = "flightId")	
    private Set<AirlineFlights> setOfflights; 
	
	public String getCode() {
		return code;
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
	
	public Set<AirlineFlights> getSetOfflights() {
		return setOfflights;
	}
	public void setSetOfflights(Set<AirlineFlights> setOfflights) {
		this.setOfflights = setOfflights;
	}
	
	
	
}
