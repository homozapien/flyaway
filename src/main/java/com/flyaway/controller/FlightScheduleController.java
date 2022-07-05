package com.flyaway.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.Airline;
import com.flyaway.entities.CityAirport;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.service.FlightScheduleService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FlightScheduleController
 */
public class FlightScheduleController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(FlightScheduleController.class);
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FlightScheduleController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		String flightId            = request.getParameter("flightId");
		String airlineId           = request.getParameter("airlineId");
		String deptAirport         = request.getParameter("deptAirport");
		String destAirport         = request.getParameter("destAirport");		 
		String numOfConnections    = request.getParameter("numOfConnections");
		String ticketPrice         = request.getParameter("ticketPrice");
		String availableDate       = request.getParameter("availableDate");
		
		FlightSchedule schedule = new FlightSchedule();
		
		schedule.setFlightId(flightId);
		
		Airline airline = new Airline();
		airline.setId(airlineId);
		schedule.setAirline(airline);
		
		CityAirport deptCityAirport = new CityAirport();
		deptCityAirport.setCode(deptAirport);
		schedule.setCityAirportDept(deptCityAirport);
		
		CityAirport destCityAirport  = new CityAirport();
		destCityAirport.setCode(destAirport);
		schedule.setCityAirportDest(destCityAirport);
		
		schedule.setNumOfConnections(Integer.valueOf(numOfConnections));
		schedule.setTicketPrice(Double.valueOf(ticketPrice));
		schedule.setAvailableDate(LocalDate.parse(availableDate));
		
		
		FlightScheduleService scheduleService = new FlightScheduleService();
		
		String result = scheduleService.createFlightSchedule(schedule);
		
		RequestDispatcher rd1 = request.getRequestDispatcher("success.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("failure.jsp");
		
		if(result.equals("Success")) 
		{
			rd1.forward(request, response);
	    }
		else
		{
			rd2.forward(request, response);
	   }
	}

}
