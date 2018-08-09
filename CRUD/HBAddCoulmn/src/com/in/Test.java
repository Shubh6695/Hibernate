package com.in;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

public static void testADD()throws Exception
{
	
	EmployeeDTO dt= new EmployeeDTO();
	
	dt.setFname("Hitansh");
	
	dt.setLname("Joshi");
	
	dt.setAddress("Delhi");
	
	dt.setMobile(8887776660l);

	dt.setPincode(111111);
	
	//create Session Factory object
	
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		
		//Create Session Object
		
		Session s = sessionFactory.openSession();
		
		
		// Create Transaction Object
		
		Transaction tx = s.beginTransaction();

		
		s.save(dt); 


		tx.commit();
		
		s.close();


	
	
	
}
	


public static void testUPDATE()throws Exception
{


	EmployeeDTO dt=new EmployeeDTO();
	
	dt.setId(2);
	
	dt.setMobile(101010);

	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	
	Session s=sf.openSession();
	
	
	Transaction tx=s.beginTransaction();
	
	
	s.update(dt);
	
	tx.commit();
	
	s.close();
	

}
	
	
	public static void main(String[] args) throws Exception
	{

		testADD();

	//	testUPDATE();
		
	}

}
