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
		
		
		CustomerDTO cdto=new CustomerDTO();
		
		cdto.setCustomerid(501);
		
		cdto.setFname("Shubham");
		
		cdto.setLname("Tale");
		
		cdto.setEmail("shubham@gmail.com");
		
		cdto.setAddress("Indore");
		
		cdto.setMobile(112233);
		
		
		
														OrderDTO odto1=new OrderDTO();
														
														odto1.setOrderid(101);
		
														odto1.setDescription("FOOD");
														
														odto1.setAmount(5000);
														
														odto1.setStatus("PAID");
														
														odto1.setCustomerParent(cdto);
														
														
														
														OrderDTO odto2=new OrderDTO();
														
														odto2.setOrderid(102);
														
														odto2.setDescription("ELECTRONICS");
														
														odto2.setAmount(70000);
														
														odto2.setStatus("UnPaid");
														
														odto2.setCustomerParent(cdto);
														
														
														
														
														OrderDTO odto3=new OrderDTO();
														
														odto3.setOrderid(103);
														
														odto3.setDescription("BOOK");
														
														odto3.setAmount(15000);
														
														odto3.setStatus("UnPaid");
														
														odto3.setCustomerParent(cdto);
														
														
														
														sess.save(odto1);
														
														sess.save(odto2);
														
														sess.save(odto3);
														
														
				Transaction ts=sess.beginTransaction();
				
				ts.commit();
				
				
				System.out.println("Insert Successfully");		
														
				sess.close();
				
				sf.close();
				
				
		
	}
	
	
	public static void GetBOTH() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from OrderDTO");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		while(itr.hasNext())
		{
			
			OrderDTO odto=(OrderDTO) itr.next();
			
			
			System.out.println("Order Detail's");
			
			System.out.println(odto.getOrderid()+"\t"+odto.getDescription()+"\t"+odto.getAmount()+"\t"+odto.getStatus());
			
			
			System.out.println();
			
			
			System.out.println("Customer Detail's");
			
			
			System.out.println(odto.getCustomerParent().getCustomerid()+"\t"+odto.getCustomerParent().getFname()+"\t"+odto.getCustomerParent().getLname()+"\t"+odto.getCustomerParent().getAddress()
					
					+"\t"+odto.getCustomerParent().getAddress()+"\t"+odto.getCustomerParent().getMobile());
					
			
			
			
		}
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	InsertALL();
		
		
		GetBOTH();
		
		
	}
	

}
