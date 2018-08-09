package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	
	public static void Insert_ONE_TO_MANY() throws Exception
	{
		
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO v1=new VendorDTO();
		
		v1.setVendorid(101);
		
		v1.setVendorname("DELL");
		
		
		
		VendorDTO v2=new VendorDTO();
		
		v2.setVendorid(102);
		
		v2.setVendorname("APPLE");
		
		
		
																	CustomerDTO c1=new CustomerDTO();
																	
																	c1.setCustomerid(501);
		
																	c1.setCustomername("Shubham");
		
																	
																	
																	CustomerDTO c2=new CustomerDTO();
																	
																	c2.setCustomerid(502);
		
																	c2.setCustomername("Aman");
																	
		
			Set s=new HashSet();
			
			s.add(c1);
			
			s.add(c2);
						
			
			v1.setCustomerChild(s);
									
			v2.setCustomerChild(s);
		
			
			
			Transaction ts=sess.beginTransaction();
			
			sess.save(v1);
			
			sess.save(v2);
			
			ts.commit();
			
			
			System.out.println("Insert Successfully");

			
			sess.close();
			
			sf.close();
			
			
	}
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		VendorDTO v1=new VendorDTO();
		
		v1.setVendorid(103);
		
		v1.setVendorname("HP");
		
		
		
		VendorDTO v2=new VendorDTO();
		
		v2.setVendorid(104);
		
		v2.setVendorname("SONY");
		
		
		
																	CustomerDTO c1=new CustomerDTO();
																	
																	c1.setCustomerid(503);
		
																	c1.setCustomername("Hitansh");
		
																	
																	
																	CustomerDTO c2=new CustomerDTO();
																	
																	c2.setCustomerid(504);
		
																	c2.setCustomername("Deepak");
																	
		
			Set s=new HashSet();
			
			s.add(v1);
			
			s.add(v2);
			
			
			c1.setVendorParent(s);
			
			c2.setVendorParent(s);
			
			
			Transaction ts=sess.beginTransaction();
			
			sess.save(c1);
			
			sess.save(c2);
			
			
			ts.commit();
			
			System.out.println("Insert Successfully");
		
		
			sess.close();
			
			sf.close();
			
			
	}
	
	
	public static void Get_ONE_TO_MANY() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from VendorDTO");
		
		
		List rows=q1.list();
		
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			VendorDTO vdto=(VendorDTO) itr.next();
			
			System.out.println(vdto.getVendorid()+"\t"+vdto.getVendorname());
			

			Set s=vdto.getCustomerChild();
			
			
			Iterator itr1=s.iterator();
			
			while(itr1.hasNext())
			{
				
					CustomerDTO cdto=(CustomerDTO) itr1.next();
				
					System.out.println(cdto.getCustomerid()+"\t"+cdto.getCustomername());
					
				
			}
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	Insert_ONE_TO_MANY();															// Using One-to-many
		
		
	//	Insert_MANY_TO_ONE();
		
		
		Get_ONE_TO_MANY();
		
		
	}
	
	
	
}
