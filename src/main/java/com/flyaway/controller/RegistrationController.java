package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.entities.Passenger;
import com.flyaway.service.FlightBookingService;
import com.flyaway.service.FlightScheduleService;
import com.flyaway.service.PaymentGatewayService;
import com.flyaway.service.TicketPricingService;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String flightId    = request.getParameter("flightId");
		String bookingRef  = request.getParameter("bookingRef");
		String totalCharge = request.getParameter("ticketPrice");
		String creditCard  = request.getParameter("creditCard");
		double amount = Double.valueOf(totalCharge);
		
		String result = PaymentGatewayService.performDummyPayment(creditCard, amount, "John", "Doe", "123", "05/99");
		
		if(result.equals("SUCCESS"))
		{
			FlightBookingService fsb = new FlightBookingService();
			int count = fsb.updateBookingDetails(bookingRef);
			
			if(count > 0)
			{
				//retrieve booking details and forward to confirmation page
				List<Passenger> listOfPassengers =   fsb.findPassengersBookingDetail(bookingRef);
				FlightBooking   flightBooking    =   fsb.findABookingDetail(bookingRef);
				FlightScheduleService fss        =   new FlightScheduleService();
				FlightSchedule flightSchedule    =   fss.getFlightScheduleDetails(flightId);
				
				request.setAttribute("listOfPassengers", listOfPassengers);
				request.setAttribute("flightBooking",    flightBooking);
				request.setAttribute("flightSchedule",   flightSchedule);				
				request.setAttribute("msg", "Booking payment was successfull and your flight booking is confirmed!");
				
				request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			}
		}
		else
		{
			
		}
		
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
			
			String ticketPrice = (String)request.getSession().getAttribute("ticketPrice");
			String totalCharge = String.valueOf(TicketPricingService.calculateTicketPrice(ticketPrice, passengerNum));
			
			request.setAttribute("msg", "Booking refernce successfully created with Passenger details; you need to make payment for confirmation");
			request.setAttribute("booking", booking);
			request.setAttribute("passenger", passenger);
			request.setAttribute("flightId", flightId);
			request.setAttribute("totalCharge", totalCharge);
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
