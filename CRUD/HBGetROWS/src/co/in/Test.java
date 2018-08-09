package co.in;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test {


	public static void testGET() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session s=sf.openSession();
		
		
		StudentDTO dto=(StudentDTO)s.get(StudentDTO.class, 4);
		
		
		
		System.out.println("Output :-  ");
		
		
		System.out.println("ID :- "+dto.getId());
		
		System.out.println("USER-ID :- "+dto.getUserid());
		
		System.out.println("Password :- "+dto.getPassword());
		
		System.out.println("Fname :- "+dto.getFname());
		
		System.out.println("Lname :- "+dto.getLname());
		
		System.out.println("Address :- "+dto.getAddress());
		
	}
	
	public static void main(String[] args) throws Exception
	{

		testGET();
	}

}
