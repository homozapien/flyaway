package com.flyaway.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.CityAirport;
import com.flyaway.service.CityAirportService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CityAirportController
 */
public class CityAirportController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(CityAirportController.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityAirportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		String code     =      request.getParameter("airportcode");
		String city     =      request.getParameter("airportcity");
		String country  =      request.getParameter("airportcountry"); 
				
		CityAirportService  service = new CityAirportService ();
		String result =    service.createCityAirport(new CityAirport(code, city, country ));
		
		RequestDispatcher rd1 = request.getRequestDispatcher("success.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("failure.jsp");
		
		if(result.equals("Success")) 
		{
			rd1.forward(request, response);
			//response.sendRedirect("success.jsp");
	    }
		else
		{
			rd2.forward(request, response);
			//response.sendRedirect("failure.jsp");
	   }
		
	}

}
