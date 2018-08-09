package co.in;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Test {

	
	public static void testUPDATE()throws Exception
	{
		
		EmployeeDTO dto=new EmployeeDTO();
		
		dto.setId(2);
		
	//	dto.setFname("Suresh");
		
	//	dto.setLname("Sharma");
		
		dto.setAddress("Pune");
		
	//	dto.setMobile(2221113335l);
		
		
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		Transaction ts=s.beginTransaction();
		
		
		
		s.update(dto);
		
		
		ts.commit();
		
		s.clear();
		
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
	
		testUPDATE();

	}

}
