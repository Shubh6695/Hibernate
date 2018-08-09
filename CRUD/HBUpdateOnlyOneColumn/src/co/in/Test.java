package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {


	public static void testUPDATE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		Transaction ts=s.beginTransaction();
		
		
		StudentDTO dto=(StudentDTO)s.get(StudentDTO.class, 2);
		
		
	
		
		dto.setUserid("1002");
		
		
		s.update(dto);
		
		
		ts.commit();
		
		s.close();
		
		
			
	}
	
	public static void main(String[] args) throws Exception
	{

		testUPDATE();
	}

}
