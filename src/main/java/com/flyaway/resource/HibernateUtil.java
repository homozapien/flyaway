package com.flyaway.resource;

import java.io.File;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil 
{
	private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

	private static SessionFactory sf;
	private static String HIBER_CONFIG_FILE = "src/main/java/hibernate.cfg.xml";
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	static 
	{
		logger.debug(">>>>>>>>>> Start of creation of Hibernate Sessionfactory <<<<<<<<<<<<<");
		
		try 
		{
			Configuration con = new Configuration();
			
			File configFile = new File(HIBER_CONFIG_FILE);
			
			logger.debug(">>>>>Hibernate config file was located at " + configFile.getAbsolutePath());
			
			con.configure(configFile.toURI().toURL());
			
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
					.applySettings(con.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sf = con.buildSessionFactory(serviceRegistry);
			logger.debug(">>>>>>>>>> Hibernate SessionFactory was successfully instantiated; and ready for usage  <<<<<<<<<<<<<");
			
		} 
		catch (Throwable th) 
		{
			logger.catching(th);
		}
	}

	public static SessionFactory getSessionFactoryReference() 
	{
		return sf;
	}

	public static void killSessionFactory() 
	{
		logger.debug(">>>>>>>>>> Start of Static kill Session Factory  <<<<<<<<<<<<<");
		
		if (sf != null && !sf.isClosed()) {
			sf.close();
			sf = null;
		}
		logger.debug(">>>>>>>>>> End of Static kill Session Factory  <<<<<<<<<<<<<");
		
	}

	public static Session getSession() 
	{
		logger.debug(">>>>>>>>>> Start get Hibernate Session from ThreadLocal  <<<<<<<<<<<<<");
		try 
		{
			Session session = threadLocal.get();

			if (session == null || !session.isOpen()) {
				if (sf == null) {
					rebuildSessionFactory();
				}
				session = sf.openSession();

				threadLocal.set(session);
			}

			return session;
		} 
		catch (Exception e) 
		{
			logger.error("**********I am here getsession*******", e);
		}
		
		return null;
	}

	public static void closeSession() 
	{
		Session session = threadLocal.get();
		if (session != null && session.isOpen()) {
			session.close();
		}
		threadLocal.remove();
	}

	public static void rebuildSessionFactory() {
		try {
			sf = new Configuration().configure(HIBER_CONFIG_FILE)
					.buildSessionFactory(new StandardServiceRegistryBuilder().build());

		} catch (Exception e) {
			logger.error("**********I am here close session*******", e);
		}
	}

}
