package com.flyaway.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.entities.Airline;
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
	
	 public List<FlightSchedule> getAllFlightSchedules()
	    {
	   	 
	   	 logger.debug(" >>>>> About to execute the loading of All Flight Schedules <<<<");
	   	 
	   	 List<FlightSchedule> listOfschedules = null;
		    	
			 try(Session session = HibernateUtil.getSession();)			
			 {
				 
					Query qry = session.createQuery("select schedule from FlightSchedule schedule");
					listOfschedules = qry.list();				
			 }
			 catch(Exception e)
			 {
				 logger.catching(e);
			 }
			 finally
			 {
				 logger.debug(">>> Closing in finally of FlightSchedule loading HibernateUtil.closeSession() <<<");
				 HibernateUtil.closeSession();
			 }
			 
	   	 return listOfschedules;
	    }
	 
	

}
