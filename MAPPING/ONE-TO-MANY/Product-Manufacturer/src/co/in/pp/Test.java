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
		
		
		ProductDTO pdto1=new ProductDTO();
		
		
		pdto1.setProductid(501);
		
		pdto1.setProductname("Laptop");
		
					
								ManufacturerDTO mdto1=new ManufacturerDTO();
		
								mdto1.setMid(601);
								
								mdto1.setName("DELL");
								
								mdto1.setEmail("dell@gmail.com");
								
								mdto1.setAddress("India");
								
								mdto1.setLicenceno(101010);
								
								mdto1.setValidity(2020);
								

								ManufacturerDTO mdto2=new ManufacturerDTO();
								
								mdto2.setMid(602);
								
								mdto2.setName("APPLE");
								
								mdto2.setEmail("apple@gmail.com");
								
								mdto2.setAddress("America");
								
								mdto2.setLicenceno(102030);
								
								mdto2.setValidity(2025);
							
								
								
								
								ManufacturerDTO mdto3=new ManufacturerDTO();
								
								mdto3.setMid(603);
								
								mdto3.setName("HP");
								
								mdto3.setEmail("hp@gmail.com");
								
								mdto3.setAddress("China");
								
								mdto3.setLicenceno(101020);
								
								mdto3.setValidity(2022);

			
		Set s=new HashSet();
		
		s.add(mdto1);
		
		s.add(mdto2);
		
		s.add(mdto3);
								
					
		
		pdto1.setProductChild(s);
		
								
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(pdto1);
		
		
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
