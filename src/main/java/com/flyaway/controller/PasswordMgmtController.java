package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.flyaway.entities.UserMgmt;
import com.flyaway.service.LoginService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class PasswordMgmtController
 */
public class PasswordMgmtController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PasswordMgmtController() {
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
		HttpSession hs = request.getSession();
		PrintWriter pw = response.getWriter();
		
		UserMgmt userProfile = (UserMgmt)hs.getAttribute("admin");
		
		String currentPassword      = request.getParameter("currentpassword");
		String newPassword      = request.getParameter("newpassword");
		
		if(userProfile.getPassword().equals(currentPassword))
		{
			userProfile.setPassword(newPassword);
			
			LoginService ls = new LoginService();
			
			String result = ls.changeAdminPassword(userProfile);
			
			pw.println(result);
			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		else
		{
			request.setAttribute("msg",
					"Invalid current password provided, try again ");
							
			request.getRequestDispatcher("passwordmgmt.jsp").include(request, response);
		}
		
		
		
	}

}
