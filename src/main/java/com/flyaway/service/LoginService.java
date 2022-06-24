package com.flyaway.service;

import com.flyaway.dao.LoginDAO;
import com.flyaway.pojo.Login;

public class LoginService {

	LoginDAO loginDao = new LoginDAO();

	public String checkUser(Login login)
	{
		if(login.getTypeOfUser().equals("Admin")) 
		{
			if(login.getEmail().equals("admin@gmail.com") && login.getPassword().equals("admin")) {
				return "adminSuccess";
			}else {
				return "adminFailure";
			}
		}
		else 
		{

			StringBuffer sb = new StringBuffer(login.getPassword());
			String reversePassword = sb.reverse().toString();
			login.setPassword(reversePassword);

			if(loginDao.checkLoginDetails(login)) {
				return "userSuccess";
			}else {
				return "userFailure";
			}
		}

	}

	public String createUser(Login login)
	{
		/*StringBuffer sb = new StringBuffer(login.getPassword());
		String reversePassword = sb.reverse().toString();

		login.setPassword(reversePassword);

		if(ld.createLoginDetails(login)>0) 
		{
			return "Account Created successfully";
		}else {
			return "Account didn't create";
		} */
		
		return "Account Created successfully";
	}

}
