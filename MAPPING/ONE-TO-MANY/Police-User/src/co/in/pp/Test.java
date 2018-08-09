package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;


public class Test 
{

	
	public static void InsertALL() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		PoliceDTO pdto1=new PoliceDTO();
		
		pdto1.setPid(101);
		
		pdto1.setPname("Ram");
		
		pdto1.setPdepartment("Crime");
		
		pdto1.setPstation("Vijay Nagar");
		
		pdto1.setPpost("Sub-Inspector");
		
		
								UserDTO udto1=new UserDTO();
		
								udto1.setUid(501);
								
								udto1.setName("Shubham");
		
								udto1.setEmail("shubham@gmail.com");
		
								udto1.setAddress("Indore");
								
								udto1.setMobile(999666333);
								

								UserDTO udto2=new UserDTO();
								
								udto2.setUid(502);
								
								udto2.setName("Ankit");
		
								udto2.setEmail("ankit@gmail.com");
		
								udto2.setAddress("Bhoapl");
								
								udto2.setMobile(999888555);

								
								UserDTO udto3=new UserDTO();
								
								udto3.setUid(503);
								
								udto3.setName("Aman");
		
								udto3.setEmail("aman@gmail.com");
		
								udto3.setAddress("Ujjain");
								
								udto3.setMobile(999777444);

								
								
	Set s= new HashSet();

	s.add(udto1);
								
	s.add(udto2);

	s.add(udto3);


	pdto1.setPoliceChild(s);




	Transaction ts=sess.beginTransaction();


	sess.save(pdto1);


	ts.commit();


	System.out.println("Inserted Successfully");


	sess.close();

	sf.close();
								
								
								
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
		
		InsertALL();
		
	}
	
	
}
