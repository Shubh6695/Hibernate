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
		
		
		ProductDTO pdto1=new ProductDTO();
		
		
		pdto1.setPid(501);
		
		pdto1.setPname("Laptop");

		
		ProductDTO pdto2=new ProductDTO();
		
		pdto2.setPid(502);
		
		pdto2.setPname("Mobile");
		
					
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
		
		
		pdto1.setManufacturerChild(s);
		
		pdto2.setManufacturerChild(s);
		
		
		Transaction ts=sess.beginTransaction();
		
		
		sess.save(pdto1);		
		
		sess.save(pdto2);
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Insert_MANY_TO_ONE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		ProductDTO pdto1=new ProductDTO();
		
		
		pdto1.setPid(503);
		
		pdto1.setPname("Television");

		
		ProductDTO pdto2=new ProductDTO();
		
		pdto2.setPid(504);
		
		pdto2.setPname("Speaker");
		
					
															ManufacturerDTO mdto1=new ManufacturerDTO();
		
															mdto1.setMid(604);
								
															mdto1.setName("SONY");
								
															mdto1.setEmail("sony@gmail.com");
								
															mdto1.setAddress("Japan");
								
															mdto1.setLicenceno(106010);
								
															mdto1.setValidity(2020);
								

															ManufacturerDTO mdto2=new ManufacturerDTO();
								
															mdto2.setMid(605);
								
															mdto2.setName("MI");
								
															mdto2.setEmail("mi@gmail.com");
								
															mdto2.setAddress("China");
								
															mdto2.setLicenceno(106030);
								
															mdto2.setValidity(2026);
							
								
								
								
															ManufacturerDTO mdto3=new ManufacturerDTO();
								
															mdto3.setMid(606);
								
															mdto3.setName("PHILIPS");
								
															mdto3.setEmail("philips@gmail.com");
								
															mdto3.setAddress("Taiwan");
								
															mdto3.setLicenceno(106090);
								
															mdto3.setValidity(2022);

			
		Set s= new HashSet();
		
		s.add(pdto1);
		
		s.add(pdto2);
		
			
		mdto1.setProductParent(s);
		
		mdto2.setProductParent(s);
		
		mdto3.setProductParent(s);
		
															
															
        Transaction ts=sess.beginTransaction();
		
		
		sess.save(mdto1);		
		
		sess.save(mdto2);
		
		sess.save(mdto3);
		
		ts.commit();
		
		System.out.println("Insert Successfully");
		
		
		
		sess.close();
		
		sf.close();
		
		
	}
	
	
	public static void Get_MANY_TO_ONE() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from ManufacturerDTO");
		
		
		List rows=q1.list();
		
		Iterator itr=rows.iterator();
		
		
		while(itr.hasNext())
		{
			
			ManufacturerDTO mdto=(ManufacturerDTO) itr.next(); 
			
			Set s=mdto.getProductParent();
			
			
			Iterator itr1=s.iterator();
			

			while(itr1.hasNext())		
			{
				
				ProductDTO pdto=(ProductDTO) itr1.next();
				
				System.out.println(pdto.getPid()+"\t"+pdto.getPname());
				
				System.out.println();
				
			}
			
			
		}
				
		
		sess.close();
					
		sf.close();
		
		
	}
	
	
	
	
	public static void main(String[] args)throws Exception
	{
		
		//	Insert_ONE_TO_MANY();	
	
	
		//	Insert_MANY_TO_ONE();
	
		
			Get_MANY_TO_ONE();
		
	}
	
	
	
}
