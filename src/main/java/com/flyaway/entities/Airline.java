package com.flyaway.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "airlines", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "name"})})
public class Airline implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
    private String id;
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, 
    		//   orphanRemoval = true,
    		   mappedBy = "airline")  
	//@JoinColumn(name = "AirlineId")	//@JoinColumn(name = "id", referencedColumnName = "id")
    private Set<FlightSchedule> setOfflights; //An airline will have Unique flightIds
    
	
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
	
	public Set<FlightSchedule> getSetOfflights() {
		return setOfflights;
	}
	public void setSetOfflights(Set<FlightSchedule> setOfflights) {
		this.setOfflights = setOfflights;
	}
	  
}
