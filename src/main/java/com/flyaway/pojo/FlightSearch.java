package com.flyaway.pojo;

import java.time.LocalDate;

public class FlightSearch 
{
	private String deptCityAirport,  destCityAirport;
	private LocalDate travelDate;
	
	public FlightSearch(String deptCityAirport, String destCityAirport, LocalDate travelDate) {
		super();
		this.deptCityAirport = deptCityAirport;
		this.destCityAirport = destCityAirport;
		this.travelDate = travelDate;
	}
	public String getDeptCityAirport() {
		return deptCityAirport;
	}
	public void setDeptCityAirport(String deptCityAirport) {
		this.deptCityAirport = deptCityAirport;
	}
	public String getDestCityAirport() {
		return destCityAirport;
	}
	public void setDestCityAirport(String destCityAirport) {
		this.destCityAirport = destCityAirport;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	
	@Override
	public String toString() {
		return "FlightSearch [deptCityAirport=" + deptCityAirport + ", destCityAirport=" + destCityAirport
				+ ", travelDate=" + travelDate + "]";
	}

	
	

}
