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
	
	 public List<CityAirport> getAllCityAirports()
     {
    	 
    	 logger.debug(" >>>>> About to execute the loading of All CityAirpot <<<<");
    	 
    	 List<CityAirport> listOfairports = null;
	    	
		 try(Session session = HibernateUtil.getSession();)			
		 {
			 
				Query qry = session.createQuery("select airport from CityAirport airport");
				listOfairports = qry.list();
				
				logger.debug(">>>>> Number of cityaiport found is  <<<<< " +listOfairports.size() );
		 }
		 catch(Exception e)
		 {
			 logger.catching(e);
		 }
		 finally
		 {
			 logger.debug(">>> Closing in finally of CityAiport loading HibernateUtil.closeSession() <<<");
			 HibernateUtil.closeSession();
		 }
		 
    	 return listOfairports;
     }

}
