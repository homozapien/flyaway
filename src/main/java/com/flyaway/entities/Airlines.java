package com.flyaway.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "airlines")
public class Airlines 
{
	@Id
    private String id;
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, 
    		   orphanRemoval = true,
    		   mappedBy = "airline")  
	@JoinColumn(name = "AirlineId")	//@JoinColumn(name = "id", referencedColumnName = "id")
    private Set<AirlineFlights> setOfflights; //An airline will have Unique flightIds
    
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<AirlineFlights> getSetOfflights() {
		return setOfflights;
	}
	public void setSetOfflights(Set<AirlineFlights> setOfflights) {
		this.setOfflights = setOfflights;
	}
	  
}
