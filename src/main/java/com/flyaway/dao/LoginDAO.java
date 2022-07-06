package com.flyaway.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.UserMgmt;
import com.flyaway.util.HibernateUtil;



public class LoginDAO {

	private static final Logger logger = LogManager.getLogger(LoginDAO.class);

	public boolean checkLoginDetails(UserMgmt userProfile) 
	{
		System.out.println(">>>>>Param:  UserProfile  " + userProfile.toString());
		 try(Session session = HibernateUtil.getSession();)			
		 {
		     Query<UserMgmt> query = session.createNamedQuery("UserMgmt_FindByEmailId", UserMgmt.class)
				           .setParameter("emailId",    userProfile.getEmailId())
				            .setParameter("password",   userProfile.getPassword())
				           .setParameter("typeOfUser", userProfile.getTypeOfUser()); 
		     
		  
				             UserMgmt result = query.getSingleResult();		
		
		     return (result != null);
		
		 } 
		 catch(javax.persistence.NoResultException e)
		 {
			//logger.catching(e);
			 return false;
		 }
		 catch(Exception e)
		 {
			logger.catching(e);
			 return false;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of LoginDAO.checkLoginDetails  HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
		
	}
	
	public int changeAdminPassword(UserMgmt userProfile) 
	{
		 try(Session session = HibernateUtil.getSession();)			
		 {
		     Query query = session.createNamedQuery("UserMgmt_UpdatePassword")
				             .setParameter("emailId",    userProfile.getEmailId())
				             .setParameter("password",   userProfile.getPassword())
				             .setParameter("typeOfUser", userProfile.getTypeOfUser());
		     Transaction tran = session.getTransaction(); 
		     tran.begin();
				        int result =   query.executeUpdate();	
			 tran.commit();
		
		     return result;
		
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
			 return 0;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of LoginDAO.changeAdminPassword  HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
		
	}
	
	

}
