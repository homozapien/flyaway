package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class BookingController
 */
public class BookingController extends HttpServlet {
	private static final Logger logger = LogManager.getLogger(BookingController.class);
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BookingController() {
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
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String FlightIdToBook     =      request.getParameter("FlightIdToBook");
		int passengerNum          =      Integer.valueOf(request.getParameter("numOfPassengers")); 
		
		if (passengerNum > 0) 
		{
			
			//proceed to register page
		
		logger.debug(">>>>>>>>>>> Selected flight id to be booked is : " + FlightIdToBook + " <<<<<<");
		pw.println(">>>>>>>>>>> Selected flight id to be booked is : " + FlightIdToBook + " <<<<<<");
		
		}
		else
		{
			request.setAttribute("msg",
					"Number of passenger must be greater than 0 in the search param ");
			request.getRequestDispatcher("booking.jsp").include(request, response);
		}
		
	}

}
