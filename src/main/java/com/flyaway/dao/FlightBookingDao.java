package com.flyaway.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.FlightBooking;
import com.flyaway.util.HibernateUtil;

public class FlightBookingDao 
{
	private static final Logger logger = LogManager.getLogger(FlightScheduleDAO.class);
	
	 public int createBookingWithPassenger(FlightBooking booking)
	    {
		 logger.debug(" >>>>> About to execute to Create Flight Booking With Passenger Details <<<<");
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
			 Transaction tran = session.getTransaction();   
			 tran.begin();
				session.save(booking);
			tran.commit();
			logger.debug(">>>>> Successfully created a flight Booking Witg Passenger Details <<<<<");
			return 1;
				
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
			 return 0;
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of createBookingWithPassenger HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
	    }

	 
	 
}
