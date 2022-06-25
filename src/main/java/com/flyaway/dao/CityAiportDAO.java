package com.flyaway.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.CityAirport;
import com.flyaway.util.HibernateUtil;

public class CityAiportDAO 
{
	private static final Logger logger = LogManager.getLogger(CityAiportDAO.class);
	
	 public int createCityAirport(CityAirport cityAirport)
	    {
		 logger.debug(" >>>>> About to execute the CityAiport Creation <<<<");
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
			 Transaction tran = session.getTransaction();   
			 tran.begin();
				session.save(cityAirport);
			tran.commit();
			logger.debug(">>>>> Successful execution of the CityAiport Creation function <<<<<");
			return 1;
				
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
			 return 0;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of createCityAirport HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
	    	
	    }
	

}
