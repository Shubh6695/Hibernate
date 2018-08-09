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
		
		
		CustomerDTO cdto1= new CustomerDTO();						// 1 Object of CustomerDTO is created.
		
		
		cdto1.setCustomerid(501);
		
		cdto1.setFname("Shubham");
		
		cdto1.setLname("Tale");
		
		cdto1.setEmail("s@gmail.com");
		
		cdto1.setAddress("Indore");
		
		cdto1.setMobile(112233);
		
		
		
		
		
							OrderDTO odto1= new OrderDTO();				// 1 Object of OrderDTO is created.
							
							odto1.setOrderid(101);
							
							odto1.setDescription("FOOD");
							
							odto1.setAmount(5000);
							
							odto1.setStatus("Paid");
							
							odto1.setCid(501);
							
							
							OrderDTO odto2= new OrderDTO();				// 2 Object of OrderDTO is created.
							
							odto2.setOrderid(102);
							
							odto2.setDescription("ELECTRONICS");
							
							odto2.setAmount(70000);
							
							odto2.setStatus("UnPaid");
							
							odto2.setCid(501);
							
							
							
							OrderDTO odto3= new OrderDTO();				// 3 Object of OrderDTO is created.
							
							odto3.setOrderid(103);
							
							odto3.setDescription("BOOK");
							
							odto3.setAmount(15000);
							
							odto3.setStatus("UnPaid");
							
							odto3.setCid(501);
							
							
							
							
							
		Set s=new HashSet();
		
		s.add(odto1);
		
		s.add(odto2);
		
		s.add(odto3);
		
		cdto1.setOrderChild(s);
		
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(cdto1);
		
		ts.commit();
		
		
		System.out.println("Inserted Successfully");
		
							
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void InsertCustomerOnly() throws Exception
	{
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		CustomerDTO cdto1= new CustomerDTO();						// 1 Object of CustomerDTO is created.
		
		
		cdto1.setCustomerid(502);
		
		cdto1.setFname("Ankit");
		
		cdto1.setLname("Sharma");
		
		cdto1.setEmail("ankit@gmail.com");
		
		cdto1.setAddress("Bhopal");
		
		cdto1.setMobile(113344);
		
	
		Transaction ts=sess.beginTransaction();
		
		sess.save(cdto1);
		
		ts.commit();
		
		System.out.println("New Customer Inserted");
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	public static void main(String[] args) throws Exception
	{
		
		
		InsertALL();
		
	//	InsertCustomerOnly();
		
	}
	
	
}
