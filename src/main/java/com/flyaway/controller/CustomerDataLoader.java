package com.flyaway.controller;

import java.io.IOException;
import java.util.List;

import com.flyaway.entities.FlightSchedule;
import com.flyaway.service.FlightScheduleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



/**
 * Servlet implementation class CustomerDataLoader
 */
public class CustomerDataLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerDataLoader() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Perform an early loading of the flightSchedlues to ensure that the customer has something to search from
		HttpSession hs = request.getSession();
		response.setContentType("text/html");
		
		List<FlightSchedule> flightSchedules = new FlightScheduleService().getAllFlightSchedules();	        
		hs.setAttribute("scheduleList", flightSchedules);
		//request.setAttribute("scheduleList", flightSchedules);
		
		request.getRequestDispatcher("flightsearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
