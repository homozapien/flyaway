package com.flyaway.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.entities.FlightBooking;
import com.flyaway.entities.Passenger;
import com.flyaway.util.HibernateUtil;

public class FlightBookingDao {
	private static final Logger logger = LogManager.getLogger(FlightScheduleDAO.class);

	public int createBookingWithPassenger(FlightBooking booking) {
		logger.debug(" >>>>> About to execute to Create Flight Booking With Passenger Details <<<<");

		try (Session session = HibernateUtil.getSession();) {

			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(booking);
			tran.commit();
			logger.debug(">>>>> Successfully created a flight Booking Witg Passenger Details <<<<<");
			return 1;

		} catch (Exception e) {
			logger.catching(e);
			return 0;
		} finally {
			logger.debug(">>> Closing in finally of createBookingWithPassenger HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}
	}
	
	public int updateBookingDetails(String bookingId)
	{
		try (Session session = HibernateUtil.getSession();) {

			Transaction tran = session.getTransaction();
			
			FlightBooking booking = session.get(FlightBooking.class, bookingId);
			
			if(booking == null)
			{
				return 0;
			}
			else
			{
				tran.begin();
				   booking.setIsFlightConfirmed("Y");
				   session.update(booking); 
				tran.commit();
				return 1;
				
			}
			
		} catch (Exception e) {
			logger.catching(e);
			return 0;
		} finally {
			logger.debug(">>> Closing in finally of createBookingWithPassenger HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}
	
	public FlightBooking findABookingDetail(String bookingId)
	{
		try (Session session = HibernateUtil.getSession();) {

			return session.get(FlightBooking.class, bookingId);
			
		} catch (Exception e) {
			logger.catching(e);
			return null;
		} finally {
			logger.debug(">>> Closing in finally of findBookingDetails HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}
	
	public List<Passenger> findPassengersBookingDetail(String bookingId)
	{
		try (Session session = HibernateUtil.getSession();) {

			Query qry= session.createQuery("select passenger from Passenger passenger where bookingId = :bookingId")
			          .setParameter("bookingId", bookingId);
			
			List<Passenger> listfOfPassengers = qry.list();
			
			return listfOfPassengers;
			
		} catch (Exception e) {
			logger.catching(e);
			return null;
		} finally {
			logger.debug(">>> Closing in finally of findPassengersBookingDetail HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}
	
	public List<Passenger> findAllPassengersBookingDetail()
	{
		try (Session session = HibernateUtil.getSession();) {

			Query qry= session.createQuery("select passenger from Passenger passenger");
			
			List<Passenger> listfOfPassengers = qry.list();
			
			return listfOfPassengers;
			
		} catch (Exception e) {
			logger.catching(e);
			return null;
		} finally {
			logger.debug(">>> Closing in finally of findAllPassengersBookingDetail HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}
	
	public List<FlightBooking> findMyBookingDetails(String bookedBy)
	{
		try (Session session = HibernateUtil.getSession();) {
			
			Query qry= session.createQuery("select flightBooking from FlightBooking flightBooking where bookedBy = :bookedBy")
					          .setParameter("bookedBy", bookedBy);
			
			List<FlightBooking> listOfMyBookings = qry.list();
			return listOfMyBookings;
			
		} catch (Exception e) {
			logger.catching(e);
			return null;
		} finally {
			logger.debug(">>> Closing in finally of findMyBookingDetails HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}
	
	public List<FlightBooking> getAllBookingDetails()
	{
		try (Session session = HibernateUtil.getSession();) {
			
			Query qry= session.createQuery("select flightBooking from FlightBooking flightBooking");
			
			List<FlightBooking> allBookings = qry.list();
			return allBookings;
			
		} catch (Exception e) {
			logger.catching(e);
			return null;
		} finally {
			logger.debug(">>> Closing in finally of getAllBookingDetails HibernateUtil.closeSession() <<<");
			HibernateUtil.closeSession();
		}	
		
	}

}
