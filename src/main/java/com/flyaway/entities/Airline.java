package com.flyaway.entities;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "airlines")
public class Airline 
{
	@Id
    private String id;
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, 
    		//   orphanRemoval = true,
    		   mappedBy = "airline")  
	//@JoinColumn(name = "AirlineId")	//@JoinColumn(name = "id", referencedColumnName = "id")
    private Set<AirlineFlight> setOfflights; //An airline will have Unique flightIds
    
	
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
	
	public Set<AirlineFlight> getSetOfflights() {
		return setOfflights;
	}
	public void setSetOfflights(Set<AirlineFlight> setOfflights) {
		this.setOfflights = setOfflights;
	}
	  
}
