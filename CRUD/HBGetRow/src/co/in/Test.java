package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {

	
	public static void testGET()throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();
		
		EmployeeDTO dto=(EmployeeDTO)s.get(EmployeeDTO.class, 3);
		
		
		System.out.println("Output:- ");
		
		System.out.println("Eid :- "+dto.getEid());
		
		System.out.println("Fname :- "+dto.getFname());
		
		System.out.println("Lname :- "+dto.getLname());
		
		System.out.println("Address :- "+dto.getAddress());
		
		System.out.println("Mobile :- "+dto.getMobile());
		
		System.out.println("Pincode :- "+dto.getPincode());
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		testGET();
	}

}
