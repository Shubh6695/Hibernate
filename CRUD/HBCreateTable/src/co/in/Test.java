package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	
	public static void testADD() throws Exception
	{
		
		StudentDTO dto=new StudentDTO();
		
	//	dto.setId(1);
	
		dto.setUserid("1004");
		
		dto.setPassword("abc123");
	
		dto.setFname("Aman");
		
		dto.setLname("Jain");
		
//		dto.setAddress("Mumbai");
		
		
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		s.save(dto);
		
		ts.commit();
		
		s.close();
		
		
		
		
	}
	
	
	public static void main(String[] args)  throws Exception
	{

		testADD();
		
	}

}
