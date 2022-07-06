package com.flyaway.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.entities.UserMgmt;
import com.flyaway.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		
		PrintWriter pw = response.getWriter();

		String email         = request.getParameter("email");
		String password      = request.getParameter("password");
		String typeOfUser    = request.getParameter("typeOfUser");

		UserMgmt userProfile = new UserMgmt();
		
		userProfile.setEmailId(email);
		userProfile.setPassword(password);
		userProfile.setTypeOfUser(typeOfUser);
		
		LoginService ls = new LoginService();
		
		//pass the login object to service class 
		String result = ls.checkUser(userProfile);
		
		
		RequestDispatcher rd1 = request.getRequestDispatcher("admin.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		RequestDispatcher rd3 = request.getRequestDispatcher("customer.jsp");
				
		if(result.equals("adminSuccess")) 
		{
			hs.setAttribute("admin", userProfile);
			rd1.forward(request, response);
	    }
		else if(result.equals("userSuccess"))
		{
			hs.setAttribute("user", userProfile);
			rd3.forward(request, response);
	    }
		else 
		{
			pw.println("Invalid emailId or Password");
			rd2.include(request, response);
	     } 
	}

}
