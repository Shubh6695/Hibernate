package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test {

	
	public static void testDELETE() throws Exception
	{
		
		StudentDTO dto=new StudentDTO();
		
		
		
		dto.setId(2);
		
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		s.delete(dto);
		
		ts.commit();
		
		s.close();
		
		
		
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
	
		testDELETE();
	}

}
