package com.flyaway.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.FlightSchedule;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FlightSearchController
 */
public class FlightSearchController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(FlightSearchController.class);
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FlightSearchController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession hs = request.getSession();
		
		List<FlightSchedule> flightSchedules = (List<FlightSchedule>)hs.getAttribute("scheduleList");
		logger.debug("<<<<<  flight Schedule size >>>>" + flightSchedules.size());
		
		
	}

}
