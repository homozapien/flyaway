package com.flyaway.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.UserMgmt;
import com.flyaway.service.FlightBookingService;


/**
 * Servlet implementation class CustomerBookingsController
 */
public class CustomerBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomerBookingsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		UserMgmt userProfile = (UserMgmt)request.getSession().getAttribute("user");
		
		List<FlightBooking> flightBookingList = new FlightBookingService().findMyBookingDetails(userProfile.getEmailId());
		
		request.setAttribute("flightBookingList", flightBookingList);
		
		request.getRequestDispatcher("customerbookings.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
