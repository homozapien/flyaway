package com.flyaway.dao;

import com.flyaway.pojo.Login;



public class LoginDAO {

	

	public boolean checkLoginDetails(Login ll) 
	{
				return true;
		
	}
	
	/*public int storeEmployee(Employee emp) {
		try {
			SessionFactory sf = DbSessionFactory.getSessionFactoryReference();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
				session.save(emp);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public List<Employee> getAllEmployee() {
		SessionFactory sf = DbSessionFactory.getSessionFactoryReference();
		Session session = sf.openSession();
		Query qry = session.createQuery("select emp from Employee emp");
		List<Employee> listOfEmp = qry.list();
		return listOfEmp;
	} */

}
