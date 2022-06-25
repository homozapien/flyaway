package com.flyaway.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.Airline;
import com.flyaway.entities.CityAirport;
import com.flyaway.util.HibernateUtil;

public class AirlineDAO 
{
	private static final Logger logger = LogManager.getLogger(AirlineDAO.class);
	
	 public int createAirline(Airline airline)
	    {
		 logger.debug(" >>>>> About to execute the Airline Creation Step <<<<");
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
			 Transaction tran = session.getTransaction();   
			 tran.begin();
				session.save(airline);
			tran.commit();
			logger.debug(">>>>> Successful execution of the Airline Creation function <<<<<");
			return 1;
				
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
			 return 0;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of Airline creation HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
	    	
	    }
	

}
