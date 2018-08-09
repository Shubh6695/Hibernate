package co.in.pp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class Test 
{

	
	public static void insertALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();
		
		
		ProductDTO pdto1=new ProductDTO();
		
		pdto1.setProductid(101);
		
		pdto1.setProductname("Laptop");
		
		
		
		ProductDTO pdto2=new ProductDTO();
		
		pdto2.setProductid(102);
		
		pdto2.setProductname("Mobile");
		
		
		
									ManufacturerDTO mdto1=new ManufacturerDTO();
									
									mdto1.setMid(201);
		
									mdto1.setMname("DELL");
		
									mdto1.setMemail("dell@gmail.com");
		
									
									ManufacturerDTO mdto2=new ManufacturerDTO();
									
									mdto2.setMid(202);
		
									mdto2.setMname("Apple");
		
									mdto2.setMemail("apple@gmail.com");

									
													
													CustomerDTO cdto1=new CustomerDTO();
													
													cdto1.setCid(301);
									
													cdto1.setCname("Shubham");
									
													cdto1.setCemail("shubham@gmail.com");
									
													cdto1.setCmobile(999666333);
									
									
													CustomerDTO cdto2=new CustomerDTO();
													
													cdto2.setCid(302);
									
													cdto2.setCname("Ankit");
									
													cdto2.setCemail("ankit@gmail.com");
									
													cdto2.setCmobile(999888777);
									
									
									
								

									
		Set s1=new HashSet();						// Adding Customer in a Set
		
		s1.add(cdto1);
		
		s1.add(cdto2);
						
		
		mdto1.setCustomerChild(s1);					// Adding Customer in a mdto1
		
		mdto2.setCustomerChild(s1);					// Adding Customer in a mdto2
		
		
		
		
		Set s2=new HashSet();						// Adding Manufacturer in a Set
		
		s2.add(mdto1);
		
		s2.add(mdto2);
		
		
		pdto1.setManufacturerChild(s2);				// Adding Manufacturer in a pdto1
		
		pdto2.setManufacturerChild(s2);				// Adding Manufacturer in a pdto2
		
		
		
		Transaction ts=sess.beginTransaction();
		
		sess.save(pdto1);
		
		sess.save(pdto2);
		
		
		ts.commit();
		
		
		System.out.println("Insert Successfully");
		
		
		sess.close();
		
		sf.close();
		
		
		
	}
	
	
	
	public static void getALL() throws Exception
	{
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		
		Session sess=sf.openSession();
		
		
		Query q1=sess.createQuery("from ProductDTO");
		
		List rows=q1.list();
		
		Iterator itr1=rows.iterator();
		
		while(itr1.hasNext())
		{
			
			ProductDTO pdto=(ProductDTO) itr1.next();
			
			System.out.println("PRODUCT DETAIL'S");
			
			System.out.println(pdto.getProductid()+"\t"+pdto.getProductname()+"\n");
			
			
			Set s1=pdto.getManufacturerChild();
			
			Iterator itr2=s1.iterator();
			
				System.out.println("Manufacturer Detail's");
				
				while(itr2.hasNext())
				{
				
					ManufacturerDTO mdto=(ManufacturerDTO) itr2.next();
					
					System.out.println(mdto.getMid()+"\t"+mdto.getMname()+"\t"+mdto.getMemail()+"\n");
					
					
					Set s2=mdto.getCustomerChild();
					
					Iterator itr3= s2.iterator();
					
					System.out.println("Customer Detail's");
					
							while(itr3.hasNext())
							{
								
								CustomerDTO cdto=(CustomerDTO) itr3.next();
								
								System.out.println(cdto.getCid()+"\t"+cdto.getCname()+"\t"+cdto.getCemail()+"\t"+cdto.getCmobile()+"\n");
								
							}
								
					
				}
			
			
			
		}
		
		sess.close();
		
		sf.close();
		
	}
	
	
	public static void getProduct(int PID) throws Exception
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session sess=sf.openSession();

		ProductDTO pdto=(ProductDTO) sess.get(ProductDTO.class, PID);
		
		
		System.out.println(pdto.getProductid()+"\t"+pdto.getProductname()+"\n");
		
		
		Set s=pdto.getManufacturerChild();
		
		Iterator itr1=s.iterator();
		
		while(itr1.hasNext())
		{
			
			
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception
	{
		
	//	insertALL();
		
		getALL();
		
		
		
		
		
		
		
	}
	
}
