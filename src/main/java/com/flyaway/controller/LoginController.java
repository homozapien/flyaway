package com.flyaway.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.flyaway.pojo.Login;
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
		logger.debug(">>>>>>>>>>>>> log4j 2 is working in LoginController <<< ");
		PrintWriter pw = response.getWriter();
		
		HttpSession hs = request.getSession();

		response.setContentType("text/html");

		// Receive the value from view ie jsp
		String email         = request.getParameter("email");
		String password      = request.getParameter("password");
		String typeOfUser    = request.getParameter("typeOfUser");

		// create the JavaBean class object and set the value which receive from view.
		Login login = new Login();
		login.setEmail(email);
		login.setPassword(password);
		login.setTypeOfUser(typeOfUser);
		
		LoginService ls = new LoginService();
		
		//pass the login object to service class 
		String result = ls.checkUser(login);
		RequestDispatcher rd1 = request.getRequestDispatcher("admin.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");
		RequestDispatcher rd3 = request.getRequestDispatcher("customer.jsp");
		
		hs.setAttribute("admin", login.getEmail());
		rd1.forward(request, response);
		
		/*if(result.equals("adminSuccess")) 
		{
			hs.setAttribute("admin", login.getEmail());
			rd1.forward(request, response);
	    }
		else if(result.equals("userSuccess")){
			hs.setAttribute("user", login.getEmail());
			rd3.forward(request, response);
	    }
		else 
		{
			pw.println("Invalid emailId or Password");
			rd2.include(request, response);
	     } */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
