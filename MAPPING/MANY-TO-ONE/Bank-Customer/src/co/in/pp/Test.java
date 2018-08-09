package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	public static void InsertALL() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		BankDTO bdto=new BankDTO();
		
		bdto.setBankid(1001);
		
		bdto.setBankname("STATE BANK OF INDIA");
		
		bdto.setBankemail("sbi@gmail.com");
		
		bdto.setBankaddress("Indore");
		
		bdto.setBankcontact(999666888);
		
		
		
											CustomerDTO cdto1=new CustomerDTO();
											
											cdto1.setCustomerid(101);
		
											cdto1.setFname("Shubham");
		
											cdto1.setLname("Tale");
											
											cdto1.setEmail("shubham@gmail.com");
											
											cdto1.setAddress("Indore");
		
											cdto1.setMobile(111222333);
											
											cdto1.setBankParent(bdto);
											
											
											
											
											CustomerDTO cdto2=new CustomerDTO();
											
											cdto2.setCustomerid(102);
											
											cdto2.setFname("Aman");;
											
											cdto2.setLname("Jain");;
		
											cdto2.setEmail("aman@gmail.com");
											
											cdto2.setAddress("Bhopal");
											
											cdto2.setMobile(111333444);										
											
											cdto2.setBankParent(bdto);
											
											
											
											
											CustomerDTO cdto3= new CustomerDTO();
											
											cdto3.setCustomerid(103);;
											
											cdto3.setFname("Suraj");;
											
											cdto3.setLname("Gawande");
											
											cdto3.setEmail("suraj@gmail.com");;
											
											cdto3.setAddress("Indore");
											
											cdto3.setMobile(111444555);
											
											cdto3.setBankParent(bdto);
											
											
											sess.save(cdto1);
											
											sess.save(cdto2);
											
											sess.save(cdto3);
											
											

		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
					
		sess.close();
		
		sf.close();
											
											
	}
	
	
	public static void UpdateParent(int BID) throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from CustomerDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
		
		
			CustomerDTO cdto=(CustomerDTO) itr.next();
			
			if(cdto.getBankParent().getBankid() == BID)
			{
				
			//	cdto.getBankParent().setBankname("AXIS BANK");
				
				
				cdto.getBankParent().setBankemail("axis@gmail.com");
				
				
				Transaction ts=sess.beginTransaction();
				
				sess.update(cdto);
				
				ts.commit();
				
				
				System.out.println("Parent Update Successfully");
				
				break;
				
				
			}
			
			if(cdto.getBankParent().getBankid() != BID)
			{
				
				System.out.println("BANK-ID NOT FOUND");
				
				
			}
			
			
			
		}
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void UpdateChild(int CID) throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		CustomerDTO cdto=(CustomerDTO) sess.get(CustomerDTO.class, 101);
		
		cdto.setAddress("Ujjain");
		
				
		sess.save(cdto);
		
		
		Transaction ts=sess.beginTransaction();
		
		ts.commit();
		
		
		System.out.println("Child Update Successfully");
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	
	
	{
		
	//	InsertALL();
		
		
	//	UpdateParent(1001);	
	
		
	//	UpdateChild(103);
		
		
	}
	
	
}
