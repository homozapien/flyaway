package com.flyaway.pojo;

import java.sql.Date;

public class FlightSearch 
{
	private String deptCity, deptCntry, destCity, destCntry;
	private Date travelDate;
	

	public FlightSearch(String deptCity, String deptCntry, String destCity, String destCntry, Date travelDate) {
		super();
		this.deptCity = deptCity;
		this.deptCntry = deptCntry;
		this.destCity = destCity;
		this.destCntry = destCntry;
		this.travelDate = travelDate;
	}
	
	public String getDeptCity() {
		return deptCity;
	}
	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}
	public String getDeptCntry() {
		return deptCntry;
	}
	public void setDeptCntry(String deptCntry) {
		this.deptCntry = deptCntry;
	}
	public String getDestCity() {
		return destCity;
	}
	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}
	public String getDestCntry() {
		return destCntry;
	}
	public void setDestCntry(String destCntry) {
		this.destCntry = destCntry;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	@Override
	public String toString() {
		return "FlightSearch [deptCity=" + deptCity + ", deptCntry=" + deptCntry + ", destCity=" + destCity
				+ ", destCntry=" + destCntry + ", travelDate=" + travelDate + "]";
	}
	
	
	
	

}
