package com.flyaway.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.FlightSchedule;
import com.flyaway.pojo.FlightSearch;
import com.flyaway.service.FlightSearchService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String deptCity = request.getParameter("deptCity");
		String deptCntry = request.getParameter("deptCntry");
		String destCity = request.getParameter("destCity");
		String destCntry = request.getParameter("destCntry");
		int passengerNum = Integer.valueOf(request.getParameter("numOfPassengers")); // check to be greater than Zero
		Date travelDate = Date.valueOf(request.getParameter("travelDate"));

		FlightSearch flightSearch = new FlightSearch(deptCity, deptCntry, destCity, destCntry, travelDate);

		HttpSession hs = request.getSession();

		if (passengerNum > 0) {

			List<FlightSchedule> flightSchedules = (List<FlightSchedule>) hs.getAttribute("scheduleList");

			List<FlightSchedule> matchedFlightList = FlightSearchService.searchForMatchingFlight(flightSchedules,
					flightSearch);

			if (matchedFlightList != null && !matchedFlightList.isEmpty()) {
				
				System.out.println(">>>>>>>Size mathched flight is " + matchedFlightList.size());
				
				matchedFlightList.forEach(System.out::println);
				
				request.setAttribute("matchedFlightList", matchedFlightList);
				request.getRequestDispatcher("booking.jsp").forward(request, response);
			} else {

				request.setAttribute("msg",
						"No matching flight(s) found in the admin flight schedules in the search param \n "
								+ flightSearch.toString());
				request.getRequestDispatcher("flightsearch.jsp").include(request, response);
			}
		} else {
			request.setAttribute("msg",
					"Number of passenger must be greater than 0 in the search param \n " + flightSearch.toString());
			request.getRequestDispatcher("flightsearch.jsp").include(request, response);
		}

	}

}
