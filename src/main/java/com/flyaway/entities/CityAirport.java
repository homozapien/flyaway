package com.flyaway.entities;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "cities_airports")
public class CityAirport 
{
	@Id
	private String code;      //unique airport code 
	private String city;      //city (model: source or destination)
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
