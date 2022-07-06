package com.flyaway.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.Airline;
import com.flyaway.service.AirlineService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class AirlineController
 */
public class AirlineController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(AirlineController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineController() {
        super();
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
		String id       =      request.getParameter("airlineid");
		String name     =      request.getParameter("airlinename");
				
		Airline airline = new Airline();
		airline.setId(id);
		airline.setName(name);
		
		AirlineService  service = new AirlineService ();
		String result =    service.createAirline(airline);
		
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
