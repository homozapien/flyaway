package com.flyaway.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.flyaway.entities.Airline;
import com.flyaway.entities.CityAirport;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.service.AirlineService;
import com.flyaway.service.CityAirportService;
import com.flyaway.service.FlightScheduleService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataloaderController
 */
public class DataloaderController extends HttpServlet {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		List<FlightSchedule> flightSchedules = new FlightScheduleService().getAllFlightSchedules();
        
		request.setAttribute("scheduleList", flightSchedules);
        
        List<Airline> airlines = new AirlineService().getAllAirlines();
        request.setAttribute("airlineList", airlines);
        
        List<CityAirport> airports = new CityAirportService().getAllCityAirports();
        request.setAttribute("airportList", airports);  //flightSchedules, airlines, airports
        
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
