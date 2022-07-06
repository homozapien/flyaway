package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.entities.Passenger;
import com.flyaway.service.FlightBookingService;
import com.flyaway.util.Helper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
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
		
		String flightId = request.getParameter("flightId");
		String bookedBy = request.getParameter("bookedBy");
		int passengerNum = Integer.valueOf(request.getParameter("passengerNum"));
		
		String passengerId = request.getParameter("passengerId");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String pemailId = request.getParameter("pemailId");
		
		String bookingid = Helper.generateRandomString();
		
		FlightBooking booking = new FlightBooking(bookingid, "N", passengerNum, bookedBy);
		
		FlightSchedule schedule = new FlightSchedule();
		schedule.setFlightId(flightId);
		booking.setFlightSchedule(schedule);
		
		Passenger passenger = new Passenger(passengerId, firstname, lastname,pemailId);          
		Set<Passenger> passegerSet = new HashSet<>();
		passegerSet.add(passenger);
		booking.setPassengers(passegerSet);
		booking.getPassengers().forEach(eachPassenger -> eachPassenger.setFlightBooking(booking));
		
		FlightBookingService fbs = new FlightBookingService();
		String result = fbs.createBookingWithPassenger(booking);
		
		if(result.equals("Success")) 
		{
			request.setAttribute("msg", "Booking successfully created; you need to make payment for confirmation");
			request.getRequestDispatcher("payment.jsp").forward(request, response);
			
	    }
		else
		{
			request.setAttribute("msg", "Booking process failed, try again later");
			request.setAttribute("flightIdToBook", flightId);
			request.setAttribute("passengerNum", passengerNum);
			request.getRequestDispatcher("register.jsp").forward(request, response);
	   }
		
		
		
	}

}
