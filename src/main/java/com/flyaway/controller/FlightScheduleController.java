package com.flyaway.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Date;

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
		String deptCity            = request.getParameter("deptCity");
		String destCity            = request.getParameter("destCity");
		String deptCntry           = request.getParameter("deptCntry");
		String destCntry           = request.getParameter("destCntry");
		String numOfConnections    = request.getParameter("numOfConnections");
		String ticketPrice         = request.getParameter("ticketPrice");
		String availableDate       = request.getParameter("availableDate");
		
		logger.debug(">>>>>>>> Available date : " + availableDate + " <<<<<<<");
		
		FlightSchedule schedule = new FlightSchedule();
		
		schedule.setFlightId(flightId);
		
		Airline airline = new Airline();
		airline.setId(airlineId);
		schedule.setAirline(airline);
		
		CityAirport deptCityCntry  = new CityAirport();
		deptCityCntry.setCity(deptCity);
		deptCityCntry.setCountry(deptCntry);
		schedule.setCityAirportDept(deptCityCntry);
		
		CityAirport destCityCntry  = new CityAirport();
		destCityCntry.setCity(destCity);
		destCityCntry.setCountry(destCntry);	
		schedule.setCityAirportDest(destCityCntry);
		
		schedule.setNumOfConnections(Integer.valueOf(numOfConnections));
		schedule.setTicketPrice(Double.valueOf(ticketPrice));
		schedule.setAvailableDate(Date.valueOf(availableDate));
		
		logger.debug(">>>>>>>> Available schedule.setAvailableDate : " + schedule.getAvailableDate() + " <<<<<<<");
		
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
