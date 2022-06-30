package com.flyaway.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	
     public List<Airline> getAllAirlines()
     {
    	 
    	 logger.debug(" >>>>> About to execute the loading of All Airlines <<<<");
    	 
    	 List<Airline> listOfairlines = null;
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
				Query qry = session.createQuery("select airline from Airline airline");
				listOfairlines = qry.list();
				
				logger.debug(">>>>> Number of airlines found is  <<<<<" +listOfairlines.size() );
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of Airline loading HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
		 
    	 return listOfairlines;
     }
	  
}
