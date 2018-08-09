package co.in.pp;


import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;




public class MultipleTransactionMultipleSessions 
{

	public static void MultipleSession()
	{
		
		
	SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
				Session s1=sf.openSession();														// Session  1 Start
								
																									// Every time a new Cache is Created for every new session
								System.out.println("SESIION 1 Start \n");		
		
								
				UserDTO dto1=(UserDTO)s1.get(UserDTO.class, 1);
		
			
				dto1.setFname("Vijay");
		
		
				Transaction ts1=s1.beginTransaction();
		
		
				s1.update(dto1);
		
				
				
				ts1.commit();
							
									System.out.println(" After Commit NAME is (Vijay):---"+dto1.getFname());
									
									System.out.println("SESIION 1 END \n");
				
				s1.close();																			// Session 1 End
		
		
		
				
				
		Session s2=sf.openSession();																// Session 2 Start
				
		
									System.out.println("SESIION 2 Start \n");	
		
		
		UserDTO dto2=(UserDTO)s2.get(UserDTO.class, 1);
		
		dto2.setFname("Naveen");		
				
		
		Transaction ts2= s2.beginTransaction();
		
		
		s2.update(dto2);
		

		
		ts2.commit();
		
								
								System.out.println(" After Commit NAME is (Naveen) :---"+dto2.getFname());
		
								System.out.println("SESIION 1 END \n");

		
		
		
		s2.close();																					// Session 2 End 
		
		
		
		
		
		
	}

	
	
	
	public static void main(String[] args) {
	

		MultipleSession();
		
	}

}
