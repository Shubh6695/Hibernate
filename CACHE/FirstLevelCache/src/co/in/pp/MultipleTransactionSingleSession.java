package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class MultipleTransactionSingleSession {

	
	public static void SingleSession() 
	{
		
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session s=sf.openSession();

		
				UserDTO dto=(UserDTO)s.get(UserDTO.class, 1);
				
				
				
				
				Transaction t1=s.beginTransaction();										// Transaction 1 Start
		
		
						dto.setFname("Vijay");
				
						s.update(dto);
						
						
				t1.commit();															// Transaction 1 Commited
						
				
				
				System.out.println("After Transaction 1 Name is (Vijay):---"+dto.getFname());
				
				
				
				
				Transaction t2=s.beginTransaction();									// Transaction 2 Start
				
				
						dto.setFname("Naveen");
						
						s.update(dto);
				
				t2.commit();															// Transaction 2 Commited
						
		
				
				System.out.println("After Transaction 2 Name is (Naveen):---"+dto.getFname());
				
		s.close();		
				
	}
	
	
	public static void main(String[] args) {
		
		
		
		SingleSession();

	}
}
