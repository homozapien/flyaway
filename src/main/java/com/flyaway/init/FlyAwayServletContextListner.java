package com.flyaway.init;

import com.flyaway.resource.HibernateUtil;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class FlyAwayServletContextListner
 *
 */
@WebListener
public class FlyAwayServletContextListner implements ServletContextListener {
	
	private static final Logger logger = LogManager.getLogger(FlyAwayServletContextListner.class);
  
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
    	logger.debug(">>>>>>>>>> Start of Listener Context Initialization  <<<<<<<<<<<<<");
    	HibernateUtil.getSessionFactoryReference();
    	logger.debug(">>>>>>>>>> End of Listener Context Initialization  <<<<<<<<<<<<<");
    }
	
    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
    	logger.debug(">>>>>>>>>> Start of Listener Context Destruction  <<<<<<<<<<<<<");
    	HibernateUtil.closeSession();
		HibernateUtil.killSessionFactory();
		logger.debug(">>>>>>>>>> End of Listener Context Destruction  <<<<<<<<<<<<<");
    }
}
