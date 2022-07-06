package com.flyaway.service;

import com.flyaway.dao.LoginDAO;
import com.flyaway.entities.UserMgmt;

public class LoginService {

	LoginDAO loginDao = new LoginDAO();

	public String checkUser(UserMgmt userProfile )
	{
		if(userProfile.getTypeOfUser().equalsIgnoreCase("Admin")) 
		{
			if(loginDao.checkLoginDetails(userProfile)) {
				return "adminSuccess";
			}else {
				return "adminFailure";
			}
			
		}
		else 
		{
			String email    =  userProfile.getEmailId();
			
			if(null != email && !email.isEmpty()) 
			{
				return "userSuccess";
			}
			else 
			{
				return "userFailure";
			} 
			
		}

	}

	public String changeAdminPassword(UserMgmt userProfile)
	{
		if(loginDao.changeAdminPassword(userProfile) > 0) 
		{
			return "Admin Password successfully updated";
		}else {
			return "Admin Password not updated";
		} 
		
	}

}
