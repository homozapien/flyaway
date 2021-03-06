package com.flyaway.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.Airline;
import com.flyaway.entities.CityAirport;
import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.entities.Passenger;
import com.flyaway.service.AirlineService;
import com.flyaway.service.CityAirportService;
import com.flyaway.service.FlightBookingService;
import com.flyaway.service.FlightScheduleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataloaderController
 */
public class DataloaderController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(DataloaderController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataloaderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<FlightSchedule> flightSchedules = new FlightScheduleService().getAllFlightSchedules();
		request.setAttribute("scheduleList", flightSchedules);
        
        List<Airline> airlines = new AirlineService().getAllAirlines();
        request.setAttribute("airlineList", airlines);
        
        List<CityAirport> airports = new CityAirportService().getAllCityAirports();
        request.setAttribute("airportList", airports);  
        
        FlightBookingService fsb = new FlightBookingService();
        
        List<FlightBooking> flightBookings = fsb.getAllBookingDetails();     
        List<Passenger> passengers = fsb.findAllPassengersBookingDetail();
        
        request.setAttribute("flightBookingList", flightBookings);
        request.setAttribute("passengerList", passengers);
        
        request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
