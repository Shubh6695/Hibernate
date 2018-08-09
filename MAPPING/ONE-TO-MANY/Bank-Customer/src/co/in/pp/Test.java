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
		
		
		BankDTO bdto1=new BankDTO();
		
		bdto1.setBankid(1001);
		
		bdto1.setBankname("STATE BANK OF INDIA");
		
		bdto1.setBankemail("sbi@gmail.com");
		
		bdto1.setBankaddress("Indore");
		
		bdto1.setBankcontact(999666888);
		
		
											CustomerDTO cdto1=new CustomerDTO();
											
											
											cdto1.setCustomerid(101);
											
											cdto1.setFname("Shubham");	
		
											cdto1.setLname("Tale");	
											
											cdto1.setEmail("shubham@gmail.com");
											
											cdto1.setAddress("Indore");
											
											cdto1.setMobile(111222333);
											
											

											CustomerDTO cdto2=new CustomerDTO();
											
											
											cdto2.setCustomerid(102);
											
											cdto2.setFname("Aman");	
		
											cdto2.setLname("Jain");	
											
											cdto2.setEmail("aman@gmail.com");
											
											cdto2.setAddress("Bhopal");
											
											cdto2.setMobile(111333444);

	
											CustomerDTO cdto3=new CustomerDTO();
											
											
											cdto3.setCustomerid(103);
											
											cdto3.setFname("Suraj");	
		
											cdto3.setLname("Gawande");	
											
											cdto3.setEmail("suraj@gmail.com");
											
											cdto3.setAddress("Indore");
											
											cdto3.setMobile(111444555);

											
		Set s=new HashSet();
		
		s.add(cdto1);
		
		s.add(cdto2);
		
		s.add(cdto3);
		
		
		bdto1.setBankChild(s);
								
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(bdto1);
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
											
	}
	
	public static void main(String[] args) throws Exception
	{
		
		InsertALL();
		
	}
	
	
}
