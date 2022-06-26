package com.flyaway.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.CityAirport;
import com.flyaway.entities.FlightSchedule;
import com.flyaway.util.HibernateUtil;

public class FlightScheduleDAO 
{
	private static final Logger logger = LogManager.getLogger(FlightScheduleDAO.class);
	
	 public int createFlightSchedule(FlightSchedule schedule)
	    {
		 logger.debug(" >>>>> About to execute to Create Flight Schedule <<<<");
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
			 Transaction tran = session.getTransaction();   
			 tran.begin();
				session.save(schedule);
			tran.commit();
			logger.debug(">>>>> Successfully created a flight Schedule  <<<<<");
			return 1;
				
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
			 return 0;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of createFlightSchedule HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
	    	
	    }
	

}
