package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	
	
	public static void testADD() throws Exception
	{
		
		EmployeeDTO dto=new EmployeeDTO();
		
		
		//dto.setId(2);
	
		dto.setFname("Hitansh");

		dto.setLname("Tale");
		
		dto.setAddress("Indore");
		
		dto.setMobile(1020304050);
		
		dto.setPincode(858585);
		
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
	
		
		s.save(dto);
		
		
		ts.commit();
		
		s.close();
		
		
	}
	
	
	
	
	
	public static void testDELETE() throws Exception
	{
		
		EmployeeDTO dto=new EmployeeDTO();
		
		
		dto.setId(3);
	

		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
	
		
		s.delete(dto);
		
		
		ts.commit();
		
		s.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception 
	{
	
		testDELETE();

//		testADD();
		
		
	}

}
